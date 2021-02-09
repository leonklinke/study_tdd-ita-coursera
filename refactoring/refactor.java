package refactoring;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class refactor {
//Old Code
	@Test
	public void registraUsuario(String nome)
			throws UsuarioJaRegistradoException, UsuarioComNomeVazioException,
			UsuarioInexistenteException {
		
		if (nome != null) {
			if (!nome.isEmpty()) {
				Usuario usuario = new Usuario(nome);
				List<Usuario> _usuarios;
				_usuarios = new ArrayList<Usuario>();
			if (!_usuarios.contains(usuario)) {
				_usuarios.add(usuario);
			} else
				throw new UsuarioJaRegistradoException("--->Já existe usuário com o nome \""
						+ nome + "\"! Use outro nome!");
			} else
				throw new UsuarioComNomeVazioException("--->Não pode registrar usuario com nome vazio!");
		} else
			throw new UsuarioInexistenteException("--->Não pode registrar usuario inexistente!");
	}

}
//consideration:
//bad identation
//not necessary elses found

//Refactor

class refactored {
	//New Code
		@Test
		public void registraUsuario(String nome)
				throws UsuarioJaRegistradoException, UsuarioComNomeVazioException,
				UsuarioInexistenteException 
		{
			
			if (nome == null) throw new UsuarioInexistenteException("--->Não pode registrar usuario inexistente!");
			
			if (nome.isEmpty()) throw new UsuarioComNomeVazioException("--->Não pode registrar usuario com nome vazio!");
			
			Usuario usuario = new Usuario(nome);
			List<Usuario> _usuarios =  new ArrayList<Usuario>();
			
			if (_usuarios.contains(usuario)) throw new UsuarioJaRegistradoException("--->Já existe usuário com o nome \""
					+ nome + "\"! Use outro nome!");
			
			_usuarios.add(usuario);
				
		}

	}