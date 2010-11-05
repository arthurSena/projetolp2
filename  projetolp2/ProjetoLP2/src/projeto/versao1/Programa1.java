package projeto.versao1;

import java.io.*;

import java.util.*;
import projeto.Classes.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Programa1 {
	
	private static String loginGerente;
	private static List<OperadorSistema> listaDeFuncionariosQueOperamSistema;
	private static List<Funcionario> funcionariosNormais;
	private static List<Cliente> listaDeClientes;

	private static Suite[] listaDeSuites;
	
	private static CentroDeConvencoes centroDeConvencoes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		loginGerente = "gerente";
		listaDeFuncionariosQueOperamSistema = new ArrayList<OperadorSistema>();
		funcionariosNormais = new ArrayList<Funcionario>();
		listaDeClientes = new ArrayList<Cliente>();
		listaDeSuites = new Suite[20];
		centroDeConvencoes = new CentroDeConvencoes(Suite.Estado.livre);
		carregaFuncionariosQueOperamSistema();
		carregaFuncionarios();
		carregaClientes();
		carregaCentroDeConvencoes();
		carregaSuites();
		//-------------Criando as Suites------------------
		for (int i=0;i<20;i++){
			Suite suite = new Suite(Suite.Estado.livre);
			listaDeSuites[i] = suite;
		}
		//-------------------------------------------------
		
		//----------Criando Gerente------------------------
		try{
			OperadorSistema gerente = new OperadorSistema("Brasil", "Solteiro"
		        	                                       , "00000000000","Super Funcionario","0000000"
				                                           , null, "00000000" , "gerente@gerente.com",loginGerente,"senhaGerente");
			
			if(!listaDeFuncionariosQueOperamSistema.contains(gerente)){
				listaDeFuncionariosQueOperamSistema.add(gerente);}
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		//-------------------------------------------------
		
		while(true){
			System.out.println("---------------Seja Bem Vindo!-----------------");
			System.out.println("1. Fazer Login\n"+"2. Encerrar Programa ");
			System.out.print("Escolha a sua opcao: ");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
					//menu 1 ---------------------------------------------------------------------
					menu1();	
			}
			else if(opcao.equals("2")){
				try {
					salvarInformacoes();
					System.out.print("\nPrograma Encerrado com Sucesso!\n");
					System.exit(0);
				} catch (IOException e) {
					System.out.println("Deu merda");
				}
				
			}
			else{
				System.out.println("\nOpcao Invalida");
			}
		}
	}
	
	public static void salvarInformacoes() throws IOException{
		XStream xstream = new XStream();
		
		if (!listaDeFuncionariosQueOperamSistema.isEmpty()){
			BufferedWriter writer = new BufferedWriter(new FileWriter("FuncionariosOperamSistema.xml"));
			String func = xstream.toXML(listaDeFuncionariosQueOperamSistema);
			writer.write(func);
			writer.close();
		}
		
		if(!funcionariosNormais.isEmpty()){
			BufferedWriter writer = new BufferedWriter(new FileWriter("FuncionariosNormais.xml"));
			String func = xstream.toXML(funcionariosNormais);
			writer.write(func);
			writer.close();
		}
		
		if(!listaDeClientes.isEmpty()){
			BufferedWriter writer = new BufferedWriter(new FileWriter("ListaDeClientes.xml"));
			String func = xstream.toXML(listaDeClientes);
			writer.write(func);
			writer.close();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("CentroDeConvencoes.xml"));
		String cc = xstream.toXML(centroDeConvencoes);
		writer.write(cc);
		writer.close();
		
		BufferedWriter writer1 = new BufferedWriter(new FileWriter("Suites.xml"));
		String suites = xstream.toXML(listaDeSuites);
		writer1.write(suites);
		writer1.close();
	}
	
	public static void carregaFuncionariosQueOperamSistema(){
		XStream xstream = new XStream(new DomDriver());
		try{
			FileReader reader1 = new FileReader("FuncionariosOperamSistema.xml");
			listaDeFuncionariosQueOperamSistema = ((List)xstream.fromXML(reader1));
		}
		catch(Exception e){
		
		}
	}
	
	public static void carregaFuncionarios(){
		XStream xstream = new XStream(new DomDriver());
		try{
			FileReader reader2 = new FileReader("FuncionariosNormais.xml");
			funcionariosNormais = ((List)xstream.fromXML(reader2));
		}catch(Exception e){
			
		}
	}
	
	public static void carregaClientes(){
		XStream xstream = new XStream(new DomDriver());
		try{
			FileReader reader3 = new FileReader("ListaDeClientes.xml");
			listaDeClientes = ((List)xstream.fromXML(reader3));
		}catch(Exception e){
			
		}
	}
	
	public static void carregaCentroDeConvencoes(){
		XStream xstream = new XStream(new DomDriver());
		try{
			FileReader reader4 = new FileReader("CentroDeConvencoes.xml");
			centroDeConvencoes = (CentroDeConvencoes)xstream.fromXML(reader4);
		}
		catch(Exception e){
			
		}
	}
	
	public static void carregaSuites(){
		XStream xstream = new XStream(new DomDriver());
		try{
			FileReader reader5 = new FileReader("Suites.xml");
			listaDeSuites = (Suite[])xstream.fromXML(reader5);
		}catch(Exception e){
			
		}
	}
	
	public static void menu1(){
		String login, senha;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("------------Bem vindo ao programa do Hotel Vila Jardim------------ \n ");
		System.out.print("Digite seu login: ");
		login = sc.nextLine();
		
		System.out.print("Digite sua senha: ");
		senha = sc.nextLine();
		
		boolean conseguiuLogar=false;
		
		for(int i = 0; i < listaDeFuncionariosQueOperamSistema.size(); i++){
			OperadorSistema proximoFuncionario = listaDeFuncionariosQueOperamSistema.get(i);
						
			if (login.equals(proximoFuncionario.getLogin()) && senha.equals(proximoFuncionario.getSenha()) && login.equals(loginGerente)){
				conseguiuLogar=true;
				menu2(true,proximoFuncionario);
				break;
			}
			
			else if(login.equals(proximoFuncionario.getLogin()) && senha.equals(proximoFuncionario.getSenha()) && !login.equals(loginGerente)){
				conseguiuLogar=true;
				menu2(false,proximoFuncionario);
				break;
			}
		}
		if(!(conseguiuLogar)){
			System.out.println("Login ou senha invalidos \n");
		}
	}
	
	public static void menu2(boolean ehGerente, OperadorSistema funcionarioQueEstaLogado){
		Scanner sc = new Scanner(System.in);
		String opcao;
		
		while (true){
			System.out.println("\n-----------------------------Menu2---------------------------------");
			System.out.println("\n1. cadastrar funcionario");
			System.out.println("2. cadastrar cliente ");
			System.out.println("3. Editar funcionario");
			System.out.println("4. Editar cliente ");
			System.out.println("5. Excluir registro (somente para gerente)");
			System.out.println("6. Criar Pacote");
			System.out.println("7. Editar minha informacoes");
			System.out.println("8. Gerenciamento de Suites");
			System.out.println("9. Gerenciamento do Centro De Convencoes(Registro de Eventos)");
			System.out.println("10. Adicionando servicos Adcionais");
			System.out.println("11. Efetuar CHECK-IN");
			System.out.println("11. Deslogar ");
			
			System.out.print("Digite a opcao desejada: ");
			opcao = sc.nextLine();
		    
			if(opcao.equals("1")){
				cadastraFuncionario();
			}
			
			else if(opcao.equals("2")){
				cadastrarCliente(null);
			}
			
			else if(opcao.equals("3")){
				if(!(funcionariosNormais.isEmpty())){
					System.out.print("Digite o cpf do Funcionario a ser Modificado:");
					String cpf = sc.nextLine();
					editarFuncionario(cpf);}
				else{
					System.out.println("Nao ha funcionarios cadastrados");
			
				}
			}
			
			else if(opcao.equals("4")){
				if(!(listaDeClientes.isEmpty())){
					System.out.print("Digite o cpf do Cliente a ser Modificado:");
					String cpf = sc.nextLine();
					editarCliente(cpf);}
				else{
					System.out.println("Nao ha clientes cadastrados");
				}
			}
			
			else if(opcao.equals("5")){
				
				if (ehGerente){
					System.out.print("Digite o numero do CPF do individuo que sera excluido: ");
					String cpfQueSeraExcluido = sc.nextLine();
					excluirCadastro(cpfQueSeraExcluido);			
				}
				
				else{
					System.out.println("Acesso Negado!");
				}
				
			}
			
			else if(opcao.equals("11")){
				System.out.println("\nVoce foi deslogado da sua conta\n");
				break;
			}
			
			else if(opcao.equals("7")){
				editarFuncionariosQueOperamSistema(funcionarioQueEstaLogado);
			}
			
			else if(opcao.equals("8")){
				buscarSuiteLivre();
			}
			
			else if(opcao.equals("9")){
				 centroDeConvencoes();
			}
			
			else if(opcao.equals("6")){
				try{
					criarPacote();}
				catch(Exception e){
					System.out.println("\nNao foi possivel criar pacote");
				}
				
			}
			
			else if(opcao.equals("10")){
				System.out.print("Digite o CPF do cliente: ");
				String opcao1 = sc.nextLine();
			}
			
			else{
				System.out.println("\nOpcao Invalida");
			}
		}		
		
	}
	
	public static void adcionaServicos(String cpf){
		Scanner sc = new Scanner(System.in);
		
		boolean clienteFoiEncontrado = false;
		
		Cliente cliente = null;
		int indice = 0;
		
		for (int i = 0; i< listaDeClientes.size();i++){
			if(listaDeClientes.get(i).getCPF().equals(cpf)){
				clienteFoiEncontrado = true;
				cliente =  listaDeClientes.get(i);
				indice= i;
				break;
			}
		}
		
		if(clienteFoiEncontrado){
			
			while (true){
				System.out.println("1. Adicionar Refeicao\n2. Adicionar Lanche\n3.Adicionar Massagem");
			}
			
		}
		else if(!clienteFoiEncontrado){
			System.out.println("Cliente nao esta cadastrado");
		}
		
	}
	
	public static void criarPacote()throws Exception{
		
		while(true){
		System.out.println("\n1.Pacote1: \n"+"At� 10 pessoas \nAte 1 semana\n"
							+"10% de desconto nas di�rias\n");
		System.out.println("2.Pacote2: \n"+"Ate 15 pessoas\n"+"Ate 1 semana\n"+"15% por cento de desconto nas diarias\n");
		System.out.println("3.Pacote3: \n"+"Ate 20 pessoas\n"+"Ate 2 semanas\n"+"15% por cento de desconto nas diarias\n");
		System.out.print("4.Sair\n"+"Digite sua Opcao: ");
		String opcao=lerString();
		
		if (opcao.equals("1")){
			PacoteTuristico pacote1 = new PacoteTuristico(6,9);
			int cont = 0;
			cadastrarCliente(pacote1);
			cont++;
			while(true){
				System.out.println("Voce ainda quer cadastar clientes no Pacote?\n"+"1.Sim\n"+"2.Nao");
				String opcao2 = lerString();
				if(cont>=10){
					System.out.println("Nao eh Possivel colocar mais clientes no pacote");
				}
				else if (opcao2.equals("2")){
					break;
				}
				else if(opcao2.equals("1")){
					cadastrarCliente(pacote1);
					cont++;
				}
				else{
					System.out.println("\nOpcao Invalida");
				}
			}
		}
		
		else if(opcao.equals("2")){
			PacoteTuristico pacote2 = new PacoteTuristico(7,13);
			int cont = 0;
			cadastrarCliente(pacote2);
			cont++;
			while(true){
				System.out.println("Voce ainda quer cadastar clientes no Pacote?"+"1.Sim\n"+"2.Nao");
				String opcao2 = lerString();
				if(cont>=20){
					System.out.println("Nao eh Possivel colocar mais clientes no pacote");
				}
				else if (opcao.equals("2")){
					break;
				}
				else if(opcao2.equals("1")){
					cadastrarCliente(pacote2);
					cont++;
				}
				else{
					System.out.println("\nOpcao Invalida");
				}
			}
		}
		else if(opcao.equals("3")){
			PacoteTuristico pacote3 = new PacoteTuristico(18,19);
			int cont = 0;
			cadastrarCliente(pacote3);
			cont++;
			while(true){
				System.out.println("Voce ainda quer cadastar clientes no Pacote?"+"1.Sim\n"+"2.Nao");
				String opcao2 = lerString();
				if(cont>=10){
					System.out.println("Nao eh Possivel colocar mais clientes no pacote");
				}
				else if (opcao.equals("2")){
					break;
				}
				else if(opcao2.equals("1")){
					cadastrarCliente(pacote3);
					cont++;
				}
				else{
					System.out.println("\nOpcao Invalida");
				}
			}
		}
		else if(opcao.equals("4")){
			break;
		}
		else {
			System.out.println("Opca Invalida");
		}
	}
	}
	public static void centroDeConvencoes(){
		Scanner sc = new Scanner(System.in);
		
		if (centroDeConvencoes.getEstado().equals(Suite.Estado.livre)){
			System.out.println("O centro de Convecoes esta atualmente livre");
			while(true){
			System.out.println("Voce deseja Reserva-lo? "+"\n1. Sim\n"+"2.Sair");
			String opcao = sc.nextLine();
			if (opcao.equals("1")){
				centroDeConvencoes.setEstado(Suite.Estado.reservado);
				System.out.println("Centro De Convencoes reservado com Sucesso");
				break;
			}
			else if(opcao.equals("2")){
				break;
			}
			else{
				System.out.println("\nOpcao Invalida");
			}
			}
		}
		else{
			System.out.println("O centro de Convecoes esta atualmente ocupado");
			while(true){
			System.out.println("Voce deseja desocupar o Centro De Convencoes? \n"+"1.Sim\n"+"2.Sair");
			String opcao = lerString();
			if(opcao.equals("1")){
				centroDeConvencoes.setEstado(Suite.Estado.livre);
				System.out.println("O centro de Convecoes esta atualmente livre");
				break;
			}
			else if(opcao.equals("2")){
				break;
			}
			else{
				System.out.println("\nOpcao Invalida");
			}
			}
		}
	}
	
	public static String lerString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
	}
	
	public static void buscarSuiteLivre(){
		Scanner sc = new Scanner(System.in);
		int cont = 0;
		System.out.println();
		for(Suite suites : listaDeSuites){
			if(suites.getEstado().equals(Suite.Estado.livre)){
				System.out.println((cont+1)+ ".  SUITE LIVRE");
				cont++;
			}
			if(suites.getEstado().equals(Suite.Estado.reservado)){
				System.out.println(+(cont+1)+". SUITE SE ENCONTRA RESERVADA");}
			if(suites.getEstado().equals(Suite.Estado.ocupado)){
				System.out.println((cont+1)+ ". SUITE SE ECOnTRA OCUPADA");}
		}
		
		System.out.println("Ha " + cont +" Suites Livres\n");
		while(true){
			int cont1 = 0;
			for(Suite suites : listaDeSuites){
				if(suites.getEstado().equals(Suite.Estado.livre)){
					cont1++;
				}
			}
			System.out.println("1.Reservar Suite\n"+"2.Desocupar Suite\n"+"3. Sair");
			System.out.print("O que voce deseja Fazer: ");
			String opcao = sc.nextLine();
			if(opcao.equals("1") && cont1==0){
				System.out.println("\nNao ha mais suites livres");
			}
			else if(opcao.equals("1") && cont1!=0){
				for(Suite suites : listaDeSuites){
					if(suites.getEstado().equals(Suite.Estado.livre)){
						suites.setEstado(Suite.Estado.ocupado);
						System.out.println("\nSuite Reservada com sucesso");
						break;
					}
				}
			}
			else if(opcao.equals("2")){
				for(Suite suites : listaDeSuites){
					if(suites.getEstado().equals(Suite.Estado.ocupado)){
						suites.setEstado(Suite.Estado.livre);
						System.out.println("\nSuite Desocupada com sucesso");
						break;
					}
				}
			}
			else if(opcao.equals("3")){
				break;
			}
			else{
				System.out.println("Opcao Invalida");
			}
		}
	}
	public static void editarFuncionariosQueOperamSistema(OperadorSistema funcionario){
		Scanner sc = new Scanner(System.in);
		
		while(true){
		System.out.println("Digite a opcao que voce deseja modificar: \n"+
				"1. Nome\n"+"2. Naturalidade\n"+"3. Estado Civil\n" + "4. CPF\n" +
				"5. RG\n" + "6. Telefone\n" + "7. Email\n" + "8. Estado \n" +"9. Cidade\n" +"10. Bairro\n" + "11. Rua\n" + "12. Numero\n" +
				"13. Cep\n" + "14. Login\n" + "15. Senha\n"+"16.Sair\n");
		String opcao = sc.nextLine();
		
		//--------------------Altera o Nome------------------------
		if (opcao.equals("1")){
			System.out.print("Digite o novo nome: ");
			String novoNome = sc.nextLine();
			try{
				funcionario.setNome(novoNome);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//-----------------------Altera Naturalidade ------------------
		else if(opcao.equals("2")){
			System.out.print("Digite o nova Naturalidade: ");
			String novaNaturalidade = sc.nextLine();
			try{
				funcionario.setNaturalidade(novaNaturalidade);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//--------------------Altera o Estado Civil ----------------------
		else if (opcao.equals("3")){
			System.out.print("Digite o novo Estado Civil: ");
			String novoEstadoCivil = sc.nextLine();
			try{
				funcionario.setEstadoCivil(novoEstadoCivil);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		
		//-------------------Altera o CPF -------------------------------------
		else if(opcao.equals("4")){
			System.out.print("Digite o novo CPF: ");
			String novoCPF = sc.nextLine();
			try{
				funcionario.setCPF(novoCPF);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//--------------------Altera o RG ------------------
		else if(opcao.equals("5")){
			System.out.print("Digite o novo RG: ");
			String novoRG = sc.nextLine();
			try{
				funcionario.setRG(novoRG);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
		}
		
		//---------------------Altera o Telefone------------
		else if(opcao.equals("6")){
			System.out.print("Digite o novo Telefone: ");
			String novoTelefone = sc.nextLine();
			try{
				funcionario.setTelefone(novoTelefone);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			
		}
		
		//-------------------Altera o Email ----------------
		else if(opcao.equals("7")){
			System.out.print("Digite o novo Email: ");
			String novoEmail = sc.nextLine();
			try{
				funcionario.setEmail(novoEmail);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		
		//------------------Altera o Estado ----------------
		else if (opcao.equals("8")){
			System.out.print("Digite o novo Estado: ");
			String novoEstado = sc.nextLine();
			try{
				funcionario.setEstado(novoEstado);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//--------------------Altera a Cidade------------------
		else if(opcao.equals("9")){
			System.out.print("Digite a nova Cidade: ");
			String novaCidade = sc.nextLine();
			try{
				funcionario.setCidade(novaCidade);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//-------------------Altera o Bairro---------------------
		else if(opcao.equals("10")){
			System.out.print("Digite o novo Bairro: ");
			String novoBairro = sc.nextLine();
			try{
				funcionario.setBairro(novoBairro);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//--------------------Altera a Rua-----------------
		else if(opcao.equals("11")){
			System.out.print("Digite a nova Rua: ");
			String novaRua = sc.nextLine();
			try{
				funcionario.setRua(novaRua);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//--------------------Altera o Numero da Casa------------------
		else if(opcao.equals("12")){
			System.out.print("Digite o novo Numero: ");
			String novoNumero = sc.nextLine();
			try{
				funcionario.setNumeroDaCasa(novoNumero);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		//------------------------Altera o CEP-----------------
		else if(opcao.equals("13")){
			System.out.print("Digite o novo CEP: ");
			String novoCEP = sc.nextLine();
			try{
				funcionario.setCEP(novoCEP);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		//-----------------Altera o Login--------------
		else if(opcao.equals("14")){
			System.out.print("Digite o novo Login: ");
			String novoLogin = sc.nextLine();
			
			try{
				funcionario.setLogin(novoLogin);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		//----------------------Altera A Senha------------
		else if(opcao.equals("15")){
			System.out.print("Digite a nova Senha: ");
			String novaSenha = sc.nextLine();
			
			try{
				funcionario.setSenha(novaSenha);
				listaDeFuncionariosQueOperamSistema.remove(funcionario);
				listaDeFuncionariosQueOperamSistema.add(funcionario);
				System.out.println("Alteracoes realizadas com sucesso!");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		else if(opcao.equals("16")){
			break;
		}
		else{
			System.out.println("\nOpcao Invalida\n");
		}
		}
		
	}
	
	public static void cadastraFuncionario() {
		Scanner sc = new Scanner(System.in);
		String nomeCompleto, rg, cpf, naturalidade, estadoCivil, telefone, email ,senha ,login;
		String estado, cidade, rua, bairro, numero, cep;
		Endereco endereco = null;		
		Funcionario novoFuncionario;
		OperadorSistema supervisor;
		OperadorSistema recepcionista;
		
		System.out.print("\nNome completo: ");
		nomeCompleto = sc.nextLine().trim();
		
		System.out.print("RG: "); 
		rg = sc.nextLine().trim();
		
		System.out.print("CPF: ");
		cpf = sc.nextLine().trim();
		
		System.out.print("Naturalidade: ");
		naturalidade = sc.nextLine().trim();
		
		System.out.print("Estado civil: ");
		estadoCivil = sc.nextLine().trim();
		
		System.out.print("Telefone: ");
		telefone = sc.nextLine().trim();
		
		System.out.print("E-mail: ");
		email = sc.nextLine().trim();

		System.out.println("\n----------------ENDERECO------------");
		System.out.print("Estado: ");
		estado = sc.nextLine().trim();
		
		System.out.print("Cidade: ");
		cidade = sc.nextLine().trim();
		
		System.out.print("Bairro: ");
		bairro = sc.nextLine().trim();
		
		System.out.print("Rua: ");
		rua = sc.nextLine().trim();
		
		System.out.print("Cep: ");
		cep = sc.nextLine().trim();
		
		System.out.print("Numero: ");
		numero = sc.nextLine().trim();
		
		
		try{
		    endereco = new Endereco(estado, cidade, rua, bairro, numero, cep);
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.print("O funcionario e um supervisor ou recepcionista: \n"+"1.Supervisor\n"+"2.Recepcionista\n"+"3.Demais Funcionarios: ");
		String opcao = sc.nextLine().trim();
		
		if(opcao.equals("1")){
			try{
				System.out.print("Login: ");
				login = sc.nextLine().trim();
				
				System.out.print("Senha: ");
				senha = sc.nextLine().trim();
				
				supervisor = new OperadorSistema(naturalidade, estadoCivil
                        , cpf, nomeCompleto, rg, endereco
                        , telefone, email,login, senha);
				
				listaDeFuncionariosQueOperamSistema.add(supervisor);
				System.out.println("Cadastro realizado com sucesso");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		else if(opcao.equals("2")){
			try{
				System.out.print("Login: ");
				login = sc.nextLine().trim();
				
				System.out.print("Senha: ");
				senha = sc.nextLine().trim();
				
				recepcionista = new OperadorSistema(naturalidade, estadoCivil
                        , cpf, nomeCompleto, rg, endereco
                        , telefone, email,login, senha);
				
				listaDeFuncionariosQueOperamSistema.add(recepcionista);
				System.out.println("Cadastro realizado com sucesso");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		else if(opcao.equals("3")){
			try{
				
				novoFuncionario = new Funcionario(naturalidade, estadoCivil
					                          , cpf, nomeCompleto, rg, endereco
					                          , telefone, email);
				
			    funcionariosNormais.add(novoFuncionario);
			    System.out.println("Cadastro realizado com sucesso");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void cadastrarCliente(PacoteTuristico pacote){
		Scanner sc = new Scanner(System.in);
		String cpf; String nomeCompleto; String rg; 
	    Endereco endereco = null; String telefone; String email;
	    String estado, cidade, rua, bairro, numero, cep;
	    Cliente cliente;
	    
	    System.out.print("\nNome completo: ");
		nomeCompleto = sc.nextLine().trim();
		
		System.out.print("RG: ");
		rg = sc.nextLine().trim();
		
		System.out.print("CPF: ");
		cpf = sc.nextLine().trim();
		
		System.out.print("Telefone: ");
		telefone = sc.nextLine().trim();
		
		System.out.print("E-mail: ");
		email = sc.nextLine().trim();
		
		System.out.print("Estado: ");
		estado = sc.nextLine().trim();
		
		System.out.print("Cidade: ");
		cidade = sc.nextLine().trim();
		
		System.out.print("Bairro: ");
		bairro = sc.nextLine().trim();
		
		System.out.print("Rua: ");
		rua = sc.nextLine().trim();
		
		System.out.print("Cep: ");
		cep = sc.nextLine().trim();
		
		System.out.print("Numero: ");
		numero = sc.nextLine().trim();
	    
		try{
		    endereco = new Endereco(estado, cidade, rua, bairro, numero, cep);
		    cliente = new Cliente(cpf, nomeCompleto, rg, endereco, telefone, email, pacote);
		    listaDeClientes.add(cliente);
		    System.out.println("Cadastro realizado com sucesso");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void editarCliente(String cpf){
		Scanner sc = new Scanner(System.in);
		
		boolean clienteFoiEncontrado=false;
		
		Cliente cliente = null;
		
		int indice = 0;
		
		for (int i =0; i < listaDeClientes.size(); i++){
			if(listaDeClientes.get(i).getCPF().equals(cpf)){
				cliente = listaDeClientes.get(i);
				clienteFoiEncontrado = true;
				indice = i;
				break;
			}
		}
		
		
		
		if(clienteFoiEncontrado){
			while(true){
				System.out.println("Digite a opcao que voce deseja modificar: "+
						"1. Nome\n"+"2. CPF\n" +
						"3. RG\n" + "4. Telefone\n" + "5. Email\n" + "6. Estado \n" +"7. Cidade\n" +"8. Bairro\n" + "9. Rua\n" + "10. Numero\n" +
						"11. Cep\n" + "12. Sair");
			String opcao = sc.nextLine();
			//-------------------Altera o Nome ------------------
			if (opcao.equals("1")){
				System.out.print("Digite o novo nome: ");
				String novoNome = sc.nextLine();
				try{
					cliente.setNome(novoNome);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
					
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//-------------------Altera o CPF ---------------------
			else if(opcao.equals("2")){
				System.out.print("Digite o novo CPF: ");
				String novoCPF = sc.nextLine();
				
				try{
					cliente.setCEP(novoCPF);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------------Altera o RG ------------------
			else if(opcao.equals("3")){
				System.out.print("Digite o novo RG: ");
				String novoRG = sc.nextLine();
				
				try{
					cliente.setRG(novoRG);				
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//---------------------Altera o Telefone------------
			else if(opcao.equals("4")){
				System.out.print("Digite o novo Telefone: ");
				String novoTelefone = sc.nextLine();
				
				try{
					cliente.setTelefone(novoTelefone);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//-------------------Altera Email-------------------
			else if(opcao.equals("5")){
				System.out.print("Digite o novo Email: ");
				String novoEmail = sc.nextLine();
				
				try{
					cliente.setEmail(novoEmail);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//---------------Altera Estado------------------
			else if(opcao.equals("6")){
				System.out.print("Digite o novo Email: ");
				String novoEmail = sc.nextLine();
				
				try{
					cliente.setEmail(novoEmail);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//---------------Altera Cidade ---------------------
			else if(opcao.equals("7")){
				System.out.print("Digite a nova Cidade: ");
				String novaCidade = sc.nextLine();
				
				try{
					cliente.setCidade(novaCidade);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------Altera o Bairro-------------------
			else if (opcao.equals("8")){
				System.out.println("Digite o novo Bairro: ");
				String novoBairro = sc.nextLine();
				
				try{
					cliente.setBairro(novoBairro);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//-----------------Altera a Rua ----------------------
			else if(opcao.equals("9")){
				System.out.print("Digite a nova Rua: ");
				String novaRua = sc.nextLine();
				
				try{
					cliente.setRua(novaRua);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//------------------Altera o numero da Casa----------------
			else if(opcao.equals("10")){
				System.out.print("Digite o novo Numero: ");
				String novoNumero = sc.nextLine();
				
				try{
					cliente.setNumeroDaCasa(novoNumero);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//------------------Altera o Cep--------------
			else if(opcao.equals("11")){
				System.out.print("Digite o novo CEP: ");
				String novoCEP = sc.nextLine();
				
				try{
					cliente.setCEP(novoCEP);
					listaDeClientes.remove(indice);
					listaDeClientes.add(cliente);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			else if(opcao.equals("12")){
				break;
			}
			
			else{
				System.out.println("Opcao Invalida");
			}
		}
		}
		else{
			System.out.println("Cliente nao esta Registrado!");
		}
	}
	
	public static void editarFuncionario(String cpf){
		Scanner sc = new Scanner(System.in);
		
		boolean funcionarioFoiEncontrado = false;
		
		Funcionario func = null;
		int indice = 0;
		
		for (int i = 0; i< funcionariosNormais.size();i++){
			if(funcionariosNormais.get(i).getCPF().equals(cpf)){
				funcionarioFoiEncontrado = true;
				func =  funcionariosNormais.get(i);
				indice= i;
				break;
			}
		}
		
		if (funcionarioFoiEncontrado){
			while(true){
			System.out.println("Digite a opcao que voce deseja modificar: "+
								"1. Nome\n"+"2. Naturalidade\n"+"3. Estado Civil\n" + "4. CPF\n" +
								"5. RG\n" + "6. Telefone\n" + "7. Email\n" + "8. Estado \n" +"9. Cidade\n" +"10. Bairro\n" + "11. Rua\n" + "12. Numero\n" +
								"13. Cep\n"+"14. Sair\n");
			
			String opcao = sc.nextLine();
			
			//-------------------Altera o Nome ------------------
			if (opcao.equals("1")){
				System.out.print("Digite o novo nome: ");
				String novoNome = sc.nextLine();
				try{
					func.setNome(novoNome);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//-----------------------Altera Naturalidade ------------------
			else if(opcao.equals("2")){
				System.out.print("Digite o nova Naturalidade: ");
				String novaNaturalidade = sc.nextLine();
				try{
					func.setNaturalidade(novaNaturalidade);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------------Altera o Estado Civil ----------------------
			else if (opcao.equals("3")){
				System.out.print("Digite o novo Estado Civil: ");
				String novoEstadoCivil = sc.nextLine();
				try{
					func.setEstadoCivil(novoEstadoCivil);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			
			
			//-------------------Altera o CPF -------------------------------------
			else if(opcao.equals("4")){
				System.out.print("Digite o novo nome: ");
				String novoCPF = sc.nextLine();
				try{
					func.setCPF(novoCPF);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------------Altera o RG ------------------
			else if(opcao.equals("5")){
				System.out.print("Digite o novo RG: ");
				String novoRG = sc.nextLine();
				try{
					func.setRG(novoRG);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			
			}
			
			//---------------------Altera o Telefone------------
			else if(opcao.equals("6")){
				System.out.print("Digite o novo Telefone: ");
				String novoTelefone = sc.nextLine();
				try{
					func.setTelefone(novoTelefone);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
				
			}
			
			//-------------------Altera o Email ----------------
			else if(opcao.equals("7")){
				System.out.print("Digite o novo Email: ");
				String novoEmail = sc.nextLine();
				try{
					func.setEmail(novoEmail);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			
			//------------------Altera o Estado ----------------
			else if (opcao.equals("8")){
				System.out.print("Digite o novo Estado: ");
				String novoEstado = sc.nextLine();
				try{
					func.setEstado(novoEstado);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------------Altera a Cidade------------------
			else if(opcao.equals("9")){
				System.out.print("Digite a nova Cidade: ");
				String novaCidade = sc.nextLine();
				try{
					func.setCidade(novaCidade);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//-------------------Altera o Bairro---------------------
			else if(opcao.equals("10")){
				System.out.print("Digite o novo Bairro: ");
				String novoBairro = sc.nextLine();
				try{
					func.setBairro(novoBairro);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------------Altera a Rua-----------------
			else if(opcao.equals("11")){
				System.out.print("Digite a nova Rua: ");
				String novaRua = sc.nextLine();
				try{
					func.setRua(novaRua);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			//--------------------Altera o Numero da Casa------------------
			else if(opcao.equals("12")){
				System.out.print("Digite o novo Numero: ");
				String novoNumero = sc.nextLine();
				try{
					func.setNumeroDaCasa(novoNumero);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			
			//------------------------Altera o CEP-----------------
			else if(opcao.equals("13")){
				System.out.print("Digite o novo CEP: ");
				String novoCEP = sc.nextLine();
				try{
					func.setCEP(novoCEP);
					funcionariosNormais.remove(indice);
					funcionariosNormais.add(func);
					System.out.println("Alteracoes realizadas com sucesso!");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			
			else if(opcao.equals("14")){
				break;
			}
			
			else{
				System.out.println("Opcao Invalida!");
			}
			}
		}
		
		else{
			System.out.println("Funcionario n�o foi encontrado");
		}
	}
	
	public static void excluirCadastro(String cpf){
		boolean funcionarioQueOperaSistemaRemovido = false;
		boolean funcionarioRemovido=false;
		boolean clienteRemovido=false;
		
		if(!(funcionarioQueOperaSistemaRemovido)){
			for (int i=0;i<listaDeFuncionariosQueOperamSistema.size();i++){
				if(listaDeFuncionariosQueOperamSistema.get(i).getCPF().equals(cpf)){
					listaDeFuncionariosQueOperamSistema.remove(i);
					funcionarioQueOperaSistemaRemovido = true;
					System.out.println("\nFuncionario Removido com Sucesso\n");
					break;
				}
			}
		}
		
		if(!(funcionarioQueOperaSistemaRemovido)){
		for (int i=0;i<funcionariosNormais.size();i++){
			if(funcionariosNormais.get(i).getCPF().equals(cpf)){
				funcionariosNormais.remove(i);
				funcionarioRemovido = true;
				System.out.println("\nFuncionario Removido com Sucesso\n");
				break;
			}
		}
		}
		
		if(!(funcionarioRemovido) && !(funcionarioQueOperaSistemaRemovido)){
			for (int i=0;i<listaDeClientes.size();i++){
				if(listaDeClientes.get(i).getCPF().equals(cpf)){
					listaDeClientes.remove(i);
					clienteRemovido = true;
					System.out.println("\nCliente Removido com Sucesso\n");
					break;
				}
			}
		}
		
		if(!(clienteRemovido) && !(funcionarioRemovido) && !(funcionarioQueOperaSistemaRemovido)){
			System.out.println("\nRegistro nao encontrado!");
		}
	}
}



