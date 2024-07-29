package com.todo.todo.Service;

import com.todo.todo.Model.User;
import com.todo.todo.Repository.UserRepository;
import com.todo.todo.dto.UserDTO;
import com.todo.todo.dto.UserUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            return new UserDTO(user);
        }
        return null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User userDB = optionalUser.get();
            // Reflejar y actualizar campos
            Field[] fields = UserUpdateDto.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object newValueFromPost = ReflectionUtils.getField(field, userUpdateDto);
                if (newValueFromPost != null) {
                    Field userFieldName = ReflectionUtils.findField(User.class, field.getName());
                    if (userFieldName != null) {
                        userFieldName.setAccessible(true);
                        ReflectionUtils.setField(userFieldName, userDB, newValueFromPost);
                    }
                }
            }

            return userRepository.save(userDB);
        } else {
            throw new RuntimeException("User no encontrado");
        }
    }
}
