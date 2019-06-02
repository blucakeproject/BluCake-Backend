package br.com.blucake.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.blucake.api.enums.PerfilEnum;
import br.com.blucake.api.models.Receita;
import br.com.blucake.api.models.Usuario;
import br.com.blucake.api.repositorios.ReceitaRepository;
import br.com.blucake.api.repositorios.UsuarioRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlucakeApi implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ReceitaRepository receitaRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlucakeApi.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Calendar calendar = Calendar.getInstance();

        Usuario user1;
        user1 = new Usuario(null,
                "admin",
                "admin@admin.com",
                "123",
                PerfilEnum.ROLE_ADMIN,
                "89080989089",
                "33531354",
                "8098098908908",
                "09313231222",
                "Silvar trac",
                12,
                "n tem",
                "centro",
                "Blumenau",
                "SC",
                "8915000");
        usuarioRepository.save(user1);

        Receita receita;
        receita = new Receita(null,
                "Bolo de Chocolate",
                "Boleto vegetariano de Chocolate",
                20.0,
                null,
                null,
                1L);
        receitaRepository.save(receita);
    }
}
