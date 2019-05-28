package br.com.blucake.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.blucake.api.enums.PerfilEnum;

import br.com.blucake.api.models.Usuario;


import br.com.blucake.api.repositorios.UsuarioRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlucakeApi implements CommandLineRunner {

   

    @Autowired
    UsuarioRepository usuarioRepository;

   
            

    public static void main(String[] args) {
        SpringApplication.run(BlucakeApi.class, args);
    }

    @Override
    public void run(String... args) throws Exception { 
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");        
         Calendar calendar = Calendar.getInstance();
        
        Usuario user1;
        user1 = new Usuario(null, 
                "blucake",
                "blucake@blucake", 
                "123",
                PerfilEnum.ROLE_ADMIN,
                "Leandro", "89080989089", "87897897897", "8098098908908", "088787", "908089", "Silvar trac", 67L, "bhjbcbhjvd", "hghghg", "bkbkbjk", "kkkjhkjh", "jlhlkkl",new Date());
        Usuario user2 = new Usuario(null, 
                "administrador",
                "admin@admin", 
                "123",
                PerfilEnum.ROLE_ADMIN,
                "Leandro", "89080989089", "87897897897", "8098098908908", "088787", "908089", "Silvar trac", 67L, "bhjbcbhjvd", "hghghg", "bkbkbjk", "kkkjhkjh", "jlhlkkl",new Date());
        
        Usuario user3 = new Usuario(null, 
                "administrador",
                "admin@adminsssss", 
                "123",
                PerfilEnum.ROLE_ADMIN,
                "Leandro", "89080989089", "87897897897", "8098098908908", "088787", "908089", "Silvar trac", 67L, "bhjbcbhjvd", "hghghg", "bkbkbjk", "kkkjhkjh", "jlhlkkl",new Date());
        usuarioRepository.save(user1);
        usuarioRepository.save(user2);
        usuarioRepository.save(user3);
    }
}
