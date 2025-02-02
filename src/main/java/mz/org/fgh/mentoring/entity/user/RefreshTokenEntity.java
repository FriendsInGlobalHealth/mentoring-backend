package mz.org.fgh.mentoring.entity.user;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.DateCreated;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;


@Schema(name = "RefreshTokenEntity", description = "Entidade responsavel em guardar os tokens para refresh")
@Entity(name = "RefreshTokenEntity")
@Table(name = "refresh_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RefreshTokenEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID",
            nullable = false
    )
    private Long id;

    @NonNull
    @NotBlank
    @Column(name = "USER_NAME", nullable = false, length = 100)
    private String username;

    @NonNull
    @NotBlank
    @Column(name = "REFRESH_TOKEN", nullable = false, length = 500, unique = true)
    private String refreshToken;

    @NonNull
    @NotNull
    @Column(name = "REVOKED", nullable = false)
    private Boolean revoked;

    @DateCreated // <4>
    @NonNull
    @NotNull
    @Column(name = "CREATED_AT", nullable = false)
    private Instant dateCreated;

    public RefreshTokenEntity(@NonNull String username, @NonNull String refreshToken, @NonNull Boolean revoked) {
        this.username = username;
        this.refreshToken = refreshToken;
        this.revoked = revoked;
        this.dateCreated = new Date().toInstant();
    }
}
