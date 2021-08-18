package cesde.net.parqueadero.api.controller;

import cesde.net.parqueadero.api.dtos.JwtDto;
import cesde.net.parqueadero.api.dtos.LoginUser;
import cesde.net.parqueadero.api.dtos.Message;
import cesde.net.parqueadero.api.dtos.NewUser;
import cesde.net.parqueadero.configurations.jwt.JwtProvider;
import cesde.net.parqueadero.data.model.Person;
import cesde.net.parqueadero.data.model.Rol;
import cesde.net.parqueadero.data.model.enums.RolName;
import cesde.net.parqueadero.domain.services.PersonServiceImpl;
import cesde.net.parqueadero.domain.services.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(AutController.AUTH)
@CrossOrigin
public class AutController {

    public final static String AUTH = "/auth";
    public final static String NEW_USER = "/new-user";
    public final static String LOGIN = "/login";

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonServiceImpl personService;

    @Autowired
    RolServiceImpl rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping(NEW_USER)
    public ResponseEntity<?> newUser(@Valid @RequestBody
                                             NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        if (personService.existsByDni(newUser.getDni()))
            return new ResponseEntity<>(new Message("Ese DNI ya existe"), HttpStatus.BAD_REQUEST);

        Person person = new Person(
                newUser.getDni(), newUser.getName(), passwordEncoder.encode(newUser.getPassword()),
                newUser.getLocal());

        Set<Rol> rols = new HashSet<>();
        rols.add(rolService.getByRolName(RolName.ROLE_USER).get());

        if (newUser.getRoles().contains("admin"))
            rols.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());

        person.setRols(rols);
        personService.save(person);

        return new ResponseEntity<>(new Message("Usuario Guardado"),HttpStatus.CREATED);
    }

    @PostMapping(LOGIN)
    public ResponseEntity<JwtDto> login (@Valid @RequestBody
                                         LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginUser.getDni(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity<>(jwtDto,HttpStatus.OK);
    }
}
