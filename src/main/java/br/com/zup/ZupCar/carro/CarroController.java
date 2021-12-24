package br.com.zup.ZupCar.carro;

import br.com.zup.ZupCar.carro.dtos.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<CarroDTO> exibirTodosOsCarros() {
        return carroService.pegarTodosOsCarros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO) {
        carroService.salvarCarro(carroDTO);
    }

    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro) {
        return carroService.exibirCarro(nomeDoCarro);
    }

    @PutMapping("/{nomeDoCarro}")
    public HashMap<String, URI> atualizarCarro(@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroJson) {
        return carroService.atualizarCarro(nomeDoCarro, carroJson);
    }

    @DeleteMapping("/{nomeDoCarro}")
    public void deletarCarro(@PathVariable String nomeDoCarro) {
        carroService.deletarCarroDaLista(nomeDoCarro);
    }
}
