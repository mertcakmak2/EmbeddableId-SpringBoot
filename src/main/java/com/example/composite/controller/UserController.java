package com.example.composite.controller;

import com.example.composite.dto.UserSaveDto;
import com.example.composite.embeddableIds.UserEmbeddedId;
import com.example.composite.model.Company;
import com.example.composite.model.Role;
import com.example.composite.model.User;
import com.example.composite.repository.CompanyRepository;
import com.example.composite.repository.RoleRepository;
import com.example.composite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final RoleRepository roleRepository;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody UserSaveDto userSaveDto){

        Company company = companyRepository.findById(userSaveDto.getCompanyId())
                .orElseThrow(() ->  new IllegalStateException("Böyle bir company yok"));

        UserEmbeddedId id = UserEmbeddedId.builder()
                .userId(userSaveDto.getUserId())
                .companyId(company.getId())
                .providerId(company.getProvider().getId()).build();

        if(userRepository.findById(id).isPresent()) throw new IllegalStateException("Kullanıcı zaten mevcut");

        User user = User.builder()
                .id(id)
                .name(userSaveDto.getName())
                .company(company)
                .provider(company.getProvider()).build();

        return userRepository.save(user);
    }

    @GetMapping("")
    public List<User> findAllUsers(){

        return userRepository.findAll();
    }

    @PostMapping("/role/{roleId}")
    public User addRoleToUser(@RequestBody UserEmbeddedId id, @PathVariable int roleId){

        Role role = roleRepository.findById(roleId).orElseThrow(() -> new IllegalStateException("Role bulunamadı"));
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("Kullanıcı bulunamadı"));

        user.getRoles().add(role);
        user.setRoles(user.getRoles());

        user.getRoles().stream().forEach(r -> r.setUsers(Arrays.asList(user)));

        return userRepository.save(user);
    }
}
