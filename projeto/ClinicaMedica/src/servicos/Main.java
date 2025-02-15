package servicos;

import entidades.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Medico> medicos = new ArrayList<>();
    private static List<Consulta> consultas = new ArrayList<>();


    public static void main(String[] args) {
        int opcao;
        
        do {
            System.out.println("Menu:");
            System.out.println("1 - Cadastro de Paciente");
            System.out.println("2 - Cadastro de Médico");
            System.out.println("3 - Agendamento de Consulta");
            System.out.println("4 - Prescrição de Exames");
            System.out.println("5 - Registrar Pagamento");
            System.out.println("6 - Ver Histórico de Consultas de um Paciente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n'
            
            switch(opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    cadastrarMedico();
                    break;
                case 3:
                    agendarConsulta();
                    break;
                case 4:
                    prescreverExames();
                    break;
                case 5:
                    registrarPagamento();
                    break;
                case 6:
                    historicoMedico();                
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarPaciente() {
        System.out.println("Cadastro de Paciente:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        HistoricoMedico historico = new HistoricoMedico();

        Paciente paciente = new Paciente(nome, dataNascimento, cpf, historico);
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    private static void cadastrarMedico() {
        System.out.println("Cadastro de Médico:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        HistoricoMedico historico = new HistoricoMedico();

        Medico medico = new Medico(nome, dataNascimento, cpf, crm, especialidade, historico);
        medicos.add(medico);
        System.out.println("Médico cadastrado com sucesso!");
    }

    private static void agendarConsulta() {
        System.out.println("Agendamento de Consulta:");
        
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = encontrarPacientePorCpf(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }
    
        System.out.print("Digite o CRM do médico: ");
        String crmMedico = scanner.nextLine();
        Medico medico = encontrarMedicoPorCrm(crmMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado!");
            return;
        }
    
        System.out.print("Digite a data da consulta (yyyy-MM-dd): ");
        String dataConsultaStr = scanner.nextLine();
        System.out.print("Digite o horário da consulta (HH:mm): ");
        String horarioConsulta = scanner.nextLine();
        System.out.print("Digite a duração da consulta (em minutos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();
    
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate dataConsulta = LocalDate.parse(dataConsultaStr, dateFormatter);
        LocalTime horario = LocalTime.parse(horarioConsulta, timeFormatter);
        
        Agendamento agendamento = new Agendamento(dataConsulta, horario, duracao, paciente, medico);
        
        System.out.print("Digite o status da consulta: ");
        String status = scanner.nextLine();
        
        List<Exame> examesPrescritos = new ArrayList<>();
        List<Medicamento> medicamentosPrescritos = new ArrayList<>();
    
        System.out.print("Digite o valor da consulta: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Prescricao prescricaoAssociada = new Prescricao();
        Consulta consulta = new Consulta(agendamento, status, examesPrescritos, medicamentosPrescritos, valor, prescricaoAssociada);
        paciente.getConsultas().add(consulta);
    
        System.out.println("Consulta agendada com sucesso!");
    }
    
    private static void prescreverExames() {
        System.out.println("Prescrição de Exames:");
        
        // Buscar paciente pelo CPF
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = encontrarPacientePorCpf(cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }
        
        // Buscar consulta ativa do paciente
        Consulta consultaEncontrada = null;
        for (Consulta consulta : consultas) {
            if (consulta.getAgendamento().getPaciente().equals(paciente)) {
                consultaEncontrada = consulta;
                break;
            }
        }
        
        if (consultaEncontrada == null) {
            System.out.println("Nenhuma consulta encontrada para este paciente.");
            return;
        }
        
        // Capturar exames prescritos
        List<Exame> examesPrescritos = new ArrayList<>();

        while (true) {
            System.out.print("Digite o tipo do exame (ou 'fim' para parar): ");
            String tipoExame = scanner.nextLine().trim();
        
            // Verifica se o usuário deseja encerrar a entrada de exames
            if (tipoExame.equalsIgnoreCase("fim")) break;
        
            System.out.print("Digite a data de prescrição (dd/MM/yyyy): ");
            String dataPrescricao = scanner.nextLine().trim();
        
            System.out.print("Digite a data de realização (ou deixe em branco): ");
            String dataRealizacao = scanner.nextLine().trim();
        
            System.out.print("Digite o resultado do exame (ou deixe em branco): ");
            String resultado = scanner.nextLine().trim();
        
            System.out.print("Digite a data de validade do exame (ou deixe em branco): ");
            String dataValidade = scanner.nextLine().trim();
        
            System.out.print("Digite o custo do exame: ");
            
            // Verifica se a entrada é um número antes de continuar
            while (!scanner.hasNextInt()) {
                System.out.println("Valor inválido! Digite um número para o custo do exame.");
                scanner.next(); // Consome a entrada errada
            }
            int custo = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
        
            // Criando o exame e adicionando à lista
            Exame exame = new Exame(tipoExame, dataPrescricao, dataRealizacao, resultado, dataValidade, custo);
            examesPrescritos.add(exame);
        
            System.out.println("Exame adicionado com sucesso!\n");
        }
        
        // Verifica se a consulta tem uma prescrição associada, se não tiver, cria uma nova
        if (consultaEncontrada.getPrescricao() == null) {
            consultaEncontrada.setPrescricao(new Prescricao());
        }
        
        // Adiciona os exames à prescrição
        consultaEncontrada.getPrescricao().setExamesPrescritos(examesPrescritos);
        
        System.out.println("Exames prescritos com sucesso!");
        
        
    }

    private static Consulta buscarConsultaPorCpf(String cpf) {
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getCpf().equals(cpf)) {
                return consulta;
            }
        }
        return null; // Retorna null se nenhuma consulta for encontrada
    }
    
    

    private static void registrarPagamento() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine().trim();
    
        Paciente pacienteEncontrado = encontrarPacientePorCpf(cpf);
    
        // Verifica se a consulta foi encontrada
        if (pacienteEncontrado == null) {
            System.out.println("Erro: Nenhuma consulta encontrada para o CPF informado.");
            return; // Sai da função para evitar exceções
        }
    
        // Verifica se a consulta já possui um pagamento registrado
        if (!pacienteEncontrado.temPagamentoPendente()) {
            System.out.println("Esta consulta já foi paga anteriormente.");
            return;
        }
    
        System.out.print("Digite o valor do pagamento: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir quebra de linha
    
        System.out.print("Digite o método de pagamento (Cartão, Dinheiro, PIX): ");
        String metodo = scanner.nextLine().trim();
    
        // Criar novo pagamento e associar à consulta
        Pagamento pagamento = new Pagamento(valor, metodo);
        pacienteEncontrado.getPagamentos().add(pagamento);
        pagamento.realizarPagamento();
    
        System.out.println("Pagamento registrado com sucesso!");
    }
    
    

    private static Paciente encontrarPacientePorCpf(String cpf) {
        return pacientes.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    private static Medico encontrarMedicoPorCrm(String crm) {
        return medicos.stream()
                .filter(m -> m.getCRM().equals(crm))
                .findFirst()
                .orElse(null);
    }

    private static void historicoMedico(){
        System.out.println("Digite o CPF do paciente:");
        String cpfConsulta = scanner.nextLine();
        Paciente pacienteConsulta = encontrarPacientePorCpf(cpfConsulta);
    
        if (pacienteConsulta == null) {
            System.out.println("Paciente não encontrado.");
        }
    
        System.out.println("Nome: " + pacienteConsulta.getNome());
        System.out.println("Data de Nascimento: " + pacienteConsulta.getDataNascimento());
        System.out.println("CPF: " + pacienteConsulta.getCpf());
        
        List<Consulta> consultasPaciente = pacienteConsulta.getConsultas();
        
        if (consultasPaciente.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            System.out.println("Consultas Agendadas:");
            for (Consulta consulta : consultasPaciente) {
                System.out.println("---------------------------");
                System.out.println("📅 Data: " + consulta.getAgendamento().getData());
                System.out.println("⏰ Horário: " + consulta.getAgendamento().getHorario());
                System.out.println("👨‍⚕️ Médico: " + consulta.getAgendamento().getMedicoResponsavel().getNome());
                System.out.println("📝 Status: " + consulta.getStatus());
                System.out.println("💰 Valor: R$ " + consulta.getValor());
                System.out.println("---------------------------");
            }
            }
    }
    
}
