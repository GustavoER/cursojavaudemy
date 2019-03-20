package com.gustavo.workshop.services;

import com.gustavo.workshop.domain.User;
import com.gustavo.workshop.dto.UserDto;
import com.gustavo.workshop.repository.UserRepository;
import com.gustavo.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        var user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }

    public void delete(Integer id) {
        this.userRepository.findById(id).ifPresentOrElse(x ->
                userRepository.deleteById(id), () -> {
            throw new ObjectNotFoundException("Objeto não encontrado");
        });
    }

    public User update(Integer id, User user) {
        var result = this.userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        UpdateData(user, result);
        return this.userRepository.save(result);
    }

    private void UpdateData(User user, User result) {
        result.setEmail(user.getEmail());
        result.setName(user.getName());
    }

    public User fromDTO(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
