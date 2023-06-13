package com.example.chick.controllers;

import com.example.chick.entity.*;
import com.example.chick.helpers.EmailSender;
import com.example.chick.helpers.Generator;
import com.example.chick.jwt.AuthService;
import com.example.chick.jwt.JwtAuthentication;
import com.example.chick.jwt.JwtRequest;
import com.example.chick.jwt.JwtResponse;
import com.example.chick.models.CategoryDTO;
import com.example.chick.models.ExerciseDTO;
import com.example.chick.models.UserCourseDTO;
import com.example.chick.models.UserDTO;
import com.example.chick.repo.*;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;
    private final UserCourseRepository userCourseRepository;
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    private final AuthService authService;

    final PasswordEncoder encoder;

    @GetMapping("/login")
    public UserDTO getUserByToken() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        Optional<User> user = userRepository.findByEmail(authInfo.getEmail());
        if (user.isPresent()) return UserDTO.toDto(user.get());
        else return null;
    }

    @PostMapping("/user")
    public Void saveUser(@RequestBody UserDTO userDTO) {
        User user = getUser();
        if (Objects.equals(userDTO.getEmail(), user.getEmail())) {
            User u = UserDTO.fromDto(userDTO);
            u.setPassword(user.getPassword());
            userRepository.save(u);
        }
        return null;
    }

    @PostMapping("/user/new")
    public JwtResponse saveNewUser(@RequestBody Pair<UserDTO, String> u) throws AuthException {
        UserDTO userDTO = u.getFirst();
        String password = u.getSecond();
        long count = userRepository.countByEmail(userDTO.getEmail());
        User user = UserDTO.fromDto(userDTO);
        if (count == 0) {
            user.setPassword(encoder.encode(password));
            user = userRepository.save(user);
            JwtRequest jwtRequest = new JwtRequest();
            jwtRequest.setEmail(user.getEmail());
            jwtRequest.setPassword(password);
            return authService.login(jwtRequest);
        } else {
            return new JwtResponse(null);
        }
    }

    @PostMapping("/forgotPassword")
    public Void forgotPassword(@RequestBody String email) {
        if (email.charAt(0) == '"') email = email.substring(1, email.length() - 1);
        Optional<User> u = userRepository.findByEmail(email);
        if (u.isPresent()) {
            User user = u.get();
            String newPassword = Generator.generatePassword();
            user.setPassword(encoder.encode(newPassword));
            userRepository.save(user);
            EmailSender.sendEmail(email, newPassword);
        }
        return null;
    }

    @PostMapping("/changePassword")
    public void changePassword(@RequestBody Pair<String, String> passwrods) {
        User user = getUser();
        if (encoder.matches(passwrods.getFirst(), user.getPassword())) {
            user.setPassword(encoder.encode(passwrods.getSecond()));
            userRepository.save(user);
        }
    }

    @PostMapping("/userCategory/{id}")
    @ResponseBody
    public Set<CategoryDTO> saveUserCategory(@PathVariable("id") long category_id, HttpServletResponse response) throws ErrorResponseException {
        User user = getUser();
        Optional<Category> categoryO = categoryRepository.findById(category_id);
        Category category = categoryO.orElseThrow(() -> new ErrorResponseException(HttpStatusCode.valueOf(404)));
        user.getCategories().add(category);
        user = userRepository.save(user);
        return user.getCategories().stream().map(CategoryDTO::toDto).collect(Collectors.toSet());
    }

    @DeleteMapping("/userCategory/{id}")
    public Set<CategoryDTO> deleteUserCategory(@PathVariable("id") long category_id) throws ErrorResponseException {
        User user = getUser();
        Optional<Category> categoryO = categoryRepository.findById(category_id);
        Category category = categoryO.orElseThrow(() -> new ErrorResponseException(HttpStatusCode.valueOf(404)));
        user.getCategories().remove(category);
        user = userRepository.save(user);
        return user.getCategories().stream().map(CategoryDTO::toDto).collect(Collectors.toSet());
    }

    @PostMapping("/userExercise/{id}")
    @ResponseBody
    public Set<ExerciseDTO> saveUserExercise(@PathVariable("id") long exercise_id, HttpServletResponse response) throws ErrorResponseException {
        User user = getUser();
        Optional<Exercise> exerciseO = exerciseRepository.findById(exercise_id);
        Exercise exercise = exerciseO.orElseThrow(() -> new ErrorResponseException(HttpStatusCode.valueOf(404)));
        user.getExercises().add(exercise);
        user = userRepository.save(user);
        return user.getExercises().stream().map(ExerciseDTO::toDto).collect(Collectors.toSet());
    }

    @DeleteMapping("/userExercise/{id}")
    public Set<ExerciseDTO> deleteUserExercise(@PathVariable("id") long exercise_id) throws ErrorResponseException {
        User user = getUser();
        Optional<Exercise> exerciseO = exerciseRepository.findById(exercise_id);
        Exercise exercise = exerciseO.orElseThrow(() -> new ErrorResponseException(HttpStatusCode.valueOf(404)));
        user.getExercises().remove(exercise);
        user = userRepository.save(user);
        return user.getExercises().stream().map(ExerciseDTO::toDto).collect(Collectors.toSet());
    }

    @PostMapping("/userCourse/{id}")
    public UserCourseDTO saveUserCourse(@PathVariable("id") long course_id) {
        User user = getUser();
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY), minutes = calendar.get(Calendar.MINUTE);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Optional<Course> courseO = courseRepository.findById((int) course_id);
        Course course = courseO.orElseThrow(() -> new ErrorResponseException(HttpStatusCode.valueOf(404)));
        boolean isCorrect = true;
        for (CourseExercise ce : course.getCourseExercises()) {
            if (ce.getDays() == 0 && (ce.getHours() < hours || (ce.getHours() == hours && ce.getMinutes() < minutes))) {
                isCorrect = false;
                break;
            }
        }
        for (CourseFoodset cf : course.getCourseFoodsets()) {
            if (cf.getDays() == 0 && (cf.getHours() < hours || (cf.getHours() == hours && cf.getMinutes() < minutes))) {
                isCorrect = false;
                break;
            }
        }
        if (!isCorrect) {
            calendar.add(Calendar.DATE, 1);
        }

        Date date = calendar.getTime();
        UserCourse userCourse = new UserCourse();
        userCourse.setUser(user);
        userCourse.setCourse(course);
        userCourse.setIsCompleted(false);
        userCourse.setStartDate(date);
        userCourse = userCourseRepository.save(userCourse);
        return UserCourseDTO.toDto(userCourse);
    }

    public User getUser() throws ErrorResponseException {
        Optional<User> user = userRepository.findByEmail(authService.getAuthInfo().getEmail());
        if (user.isPresent()) {
            return user.get();
        }
        throw new ErrorResponseException(HttpStatusCode.valueOf(401));
    }
}
