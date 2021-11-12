package br.com.zup.GerenciadorContas.componente;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConversorModel {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();

    }

}
