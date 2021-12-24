package br.com.zup.ZupCar.carro;

import br.com.zup.ZupCar.carro.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    public List<CarroDTO> pegarTodosOsCarros() {
        return concessionaria;
    }

    public void salvarCarro(CarroDTO carroDTO) {
        concessionaria.add(carroDTO);
    }

    public CarroDTO exibirCarro(String nomeDoCarro) {
        Optional<CarroDTO> carroOptional = concessionaria.stream()
                .filter(carro -> carro.getModelo().equalsIgnoreCase(nomeDoCarro)).findFirst();

        if (carroOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return carroOptional.get();
    }

    public HashMap<String, URI> atualizarCarro(String nomeDoCarro, CarroDTO objetoJson) {
        CarroDTO carroASerModificado = exibirCarro(nomeDoCarro);

        carroASerModificado.setModelo(objetoJson.getModelo());
        carroASerModificado.setMotor(objetoJson.getMotor());
        carroASerModificado.setCor(objetoJson.getCor());
        carroASerModificado.setAno(objetoJson.getAno());

        URI uri = UriComponentsBuilder.newInstance().scheme("http").host("localhost")
                .port(8080).path("/carros/" + nomeDoCarro).buildAndExpand("").toUri();

        HashMap<String, URI> retorno = new HashMap<>();
        retorno.put("carros", uri);

        return retorno;

    }
}
