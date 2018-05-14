package app.controllers;

import java.util.Calendar;

import app.models.Lance;
import app.models.Leilao;
import app.repositories.LanceRepository;
import app.repositories.UsuarioRepository;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class LanceController {

	private final LanceRepository lances;
	private final Result result;
	private final UsuarioRepository usuarios;
	private final Validator validator;

	public LanceController(Result result, UsuarioRepository usuarios, LanceRepository lances,Validator validator) {
		this.result = result;
		this.usuarios = usuarios;
		this.lances = lances;
		this.validator = validator;
	}
	
	@Post("/_lances")
	public void novoLance(Lance lance) {
		lance.setData(Calendar.getInstance());
		if (lance.getValor() <= 0) {
		    validator.add(new ValidationMessage("Valor inicial deve ser maior que zero!", "error"));
		}
		validator.onErrorUsePageOf(this).lance(lance.getLeilao());

		lances.salvar(lance);
		result.include("lance", lance);
		result.include("usuario", usuarios.find(lance.getUsuario().getId()));
	}
	public Lance lance(Leilao leilao) {
		return new Lance();
	}
}
