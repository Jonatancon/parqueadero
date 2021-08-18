package cesde.net.parqueadero.domain.services.impl;

import cesde.net.parqueadero.data.model.Person;
import cesde.net.parqueadero.data.model.PrincipalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonServiceImpl personService;

    public UserDetailsServiceImpl(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Person person = personService.getByDni(dni).get();
        return PrincipalUser.build(person);
    }
}
