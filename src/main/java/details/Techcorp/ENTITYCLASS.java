package details.Techcorp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ENTITYCLASS implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empID;
    private String empNAME;
    private String empPASS;
    private int empSELARY;
    @Column(name = "experience")
    private int empEXPERIENCE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return empPASS;
    }

    @Override
    public String getUsername() {
        return empNAME;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
