package servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Agendamento;
import entidades.Consulta;
import entidades.HistoricoMedico;
import entidades.Medico;
import entidades.Paciente;
import entidades.Exame;
import entidades.Medicamento;
import entidades.Prescricao;
import entidades.Pagamento;
import excecoes.HorarioIndisponivelExpetion;
import excecoes.PagamentoPendenteException;
import excecoes.EspecialidadeInvalidaException;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<Medico> medicos = new ArrayList<>();
        List<Agendamento> agendamentos = new ArrayList<>();
        List<Consulta> consultas = new ArrayList<>();
        List<Medicamento> medicamentos = new ArrayList<>();
        List<Exame> exames = new ArrayList<>();
        List<Prescricao> prescrições = new ArrayList<>();

        while (true) {
            System.out.println("Bem-vindo ao Sistema de Gerenciamento de Clínica Médica");
            System.out.println("1. Funcionalidades de Paciente");
            System.out.println("2. Funcionalidades de Médico");
            System.out.println("3. Funcionalidades de Agendamento");
            System.out.println("4. Funcionalidades de Consulta");
            System.out.println("5. Funcionalidades de Prescrição");
            System.out.println("6. Funcionalidades de Medicamento");
            System.out.println("7. Funcionalidades de Exame");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (escolha == 1) {
                // Funcionalidades de Paciente
                System.out.println("1.1. Cadastrar Paciente");
                System.out.println("1.2. Ler Paciente");
                System.out.println("1.3. Atualizar Paciente");
                System.out.println("1.4. Deletar Paciente");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Cadastrar Paciente
                    System.out.print("Nome do Paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Paciente: ");
                    String CPF = scanner.nextLine();
                    System.out.print("Data de Nascimento do Paciente: ");
                    String dataNascimento = scanner.nextLine();

                    HistoricoMedico historico = new HistoricoMedico();
                    Paciente paciente = new Paciente(nome, dataNascimento, CPF, historico);
                    pacientes.add(paciente);
                    System.out.println("Paciente cadastrado com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Paciente
                    System.out.println("Selecione o Paciente: ");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
                    }
                    int pacienteIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Paciente paciente = pacientes.get(pacienteIndex);
                    paciente.lerCadastro();
                } else if (subEscolha == 3) {
                    // Atualizar Paciente
                    System.out.println("Selecione o Paciente: ");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
                    }
                    int pacienteIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Paciente paciente = pacientes.get(pacienteIndex);
                    System.out.print("Nome do Paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Paciente: ");
                    String CPF = scanner.nextLine();
                    System.out.print("Data de Nascimento do Paciente: ");
                    String dataNascimento = scanner.nextLine();
                    paciente.atualizarCadastro(nome, dataNascimento, CPF);
                    System.out.println("Paciente atualizado com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Paciente
                    System.out.println("Selecione o Paciente: ");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
                    }
                    int pacienteIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Paciente paciente = pacientes.get(pacienteIndex);
                    paciente.deletarCadastro();
                    pacientes.remove(pacienteIndex);
                    System.out.println("Paciente deletado com sucesso!");
                }
            }
            else if (escolha == 2) {
                // Funcionalidades de Médico
                System.out.println("2.1. Cadastrar Médico");
                System.out.println("2.2. Ler Médico");
                System.out.println("2.3. Atualizar Médico");
                System.out.println("2.4. Deletar Médico");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Cadastrar Médico
                    System.out.print("Nome do Médico: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Médico: ");
                    String CPF = scanner.nextLine();
                    System.out.print("Data de Nascimento do Médico: ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("CRM do Médico: ");
                    String CRM = scanner.nextLine();
                    System.out.print("Especialidade do Médico: ");
                    String especialidade = scanner.nextLine();

                    HistoricoMedico historico = new HistoricoMedico();
                    Medico medico = new Medico(nome, dataNascimento, CPF, CRM, especialidade, historico);
                    medicos.add(medico);
                    System.out.println("Médico cadastrado com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Médico
                    System.out.println("Selecione o Médico: ");
                    for (int i = 0; i < medicos.size(); i++) {
                        System.out.println((i + 1) + ". " + medicos.get(i).getNome());
                    }
                    int medicoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Medico medico = medicos.get(medicoIndex);
                    medico.lerCadastro();
                } else if (subEscolha == 3) {
                    // Atualizar Médico
                    System.out.println("Selecione o Médico: ");
                    for (int i = 0; i < medicos.size(); i++) {
                        System.out.println((i + 1) + ". " + medicos.get(i).getNome());
                    }
                    int medicoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Medico medico = medicos.get(medicoIndex);
                    System.out.print("Nome do Médico: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do Médico: ");
                    String CPF = scanner.nextLine();
                    System.out.print("Data de Nascimento do Médico: ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("CRM do Médico: ");
                    String CRM = scanner.nextLine();
                    System.out.print("Especialidade do Médico: ");
                    String especialidade = scanner.nextLine();
                    medico.atualizarCadastro(nome, dataNascimento, CPF, CRM, especialidade);
                    System.out.println("Médico atualizado com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Médico
                    System.out.println("Selecione o Médico: ");
                    for (int i = 0; i < medicos.size(); i++) {
                        System.out.println((i + 1) + ". " + medicos.get(i).getNome());
                    }
                    int medicoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Medico medico = medicos.get(medicoIndex);
                    medico.deletarCadastro();
                    medicos.remove(medicoIndex);
                    System.out.println("Médico deletado com sucesso!");
                }
            } 
            else if (escolha == 3) {
                // Funcionalidades de Agendamento
                System.out.println("3.1. Agendar Consulta");
                System.out.println("3.2. Ler Agendamento");
                System.out.println("3.3. Atualizar Agendamento");
                System.out.println("3.4. Deletar Agendamento");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Agendar Consulta
                    if (pacientes.isEmpty() || medicos.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um paciente e um médico cadastrados para agendar uma consulta.");
                        continue;
                    }

                    System.out.print("Data da Consulta (DD/MM/AAAA): ");
                    String data = scanner.nextLine(); 
                    System.out.print("Horário da Consulta (HH:MM): ");
                    String horário = scanner.nextLine();
                    System.out.print("Duração da Consulta (minutos): ");
                    int duração = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    System.out.println("Selecione o Paciente: ");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
                    }
                    int pacienteIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Paciente paciente = pacientes.get(pacienteIndex);

                    System.out.println("Selecione o Médico: ");
                    for (int i = 0; i < medicos.size(); i++) {
                        System.out.println((i + 1) + ". " + medicos.get(i).getNome());
                    }
                    int medicoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Medico medico = medicos.get(medicoIndex);

                    Agendamento agendamento = new Agendamento(data, horário, duração, paciente, medico);
                    agendamentos.add(agendamento);
                    System.out.println("Consulta agendada com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Agendamento
                    System.out.println("Selecione o Agendamento: ");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        Agendamento agendamento = agendamentos.get(i);
                        System.out.println((i + 1) + ". Data: " + agendamento.getData() + ", Horário: " + agendamento.getHorário() + ", Paciente: " + agendamento.getPaciente().getNome() + ", Médico: " + agendamento.getMedicoResponsável().getNome());
                    }
                    int agendamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Agendamento agendamento = agendamentos.get(agendamentoIndex);
                    System.out.println("Data: " + agendamento.getData());
                    System.out.println("Horário: " + agendamento.getHorário());
                    System.out.println("Duração: " + agendamento.getDuração() + " min");
                    System.out.println("Paciente: " + agendamento.getPaciente().getNome());
                    System.out.println("Médico Responsável: " + agendamento.getMedicoResponsável().getNome());
                } else if (subEscolha == 3) {
                    // Atualizar Agendamento
                    System.out.println("Selecione o Agendamento: ");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        Agendamento agendamento = agendamentos.get(i);
                        System.out.println((i + 1) + ". Data: " + agendamento.getData() + ", Horário: " + agendamento.getHorário() + ", Paciente: " + agendamento.getPaciente().getNome() + ", Médico: " + agendamento.getMedicoResponsável().getNome());
                    }
                    int agendamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Agendamento agendamento = agendamentos.get(agendamentoIndex);

                    System.out.print("Nova Data da Consulta (DD/MM/AAAA): ");
                    String novaData = scanner.nextLine();
                    System.out.print("Novo Horário da Consulta (HH:MM): ");
                    String novoHorario = scanner.nextLine();
                    System.out.print("Nova Duração da Consulta (minutos): ");
                    int novaDuracao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    agendamento.setData(novaData);
                    agendamento.setHorário(novoHorario);
                    agendamento.setDuração(novaDuracao);
                    System.out.println("Agendamento atualizado com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Agendamento
                    System.out.println("Selecione o Agendamento: ");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        Agendamento agendamento = agendamentos.get(i);
                        System.out.println((i + 1) + ". Data: " + agendamento.getData() + ", Horário: " + agendamento.getHorário() + ", Paciente: " + agendamento.getPaciente().getNome() + ", Médico: " + agendamento.getMedicoResponsável().getNome());
                    }
                    int agendamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    agendamentos.remove(agendamentoIndex);
                    System.out.println("Agendamento deletado com sucesso!");
                }
            }
            else if (escolha == 4) {
                // Funcionalidades de Consulta
                System.out.println("4.1. Criar Consulta");
                System.out.println("4.2. Ler Consulta");
                System.out.println("4.3. Atualizar Consulta");
                System.out.println("4.4. Deletar Consulta");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Criar Consulta
                    if (agendamentos.isEmpty()) {
                        System.out.println("É necessário ter pelo menos um agendamento para criar uma consulta.");
                        continue;
                    }

                    System.out.println("Selecione o Agendamento: ");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        Agendamento agendamento = agendamentos.get(i);
                        System.out.println((i + 1) + ". Data: " + agendamento.getData() + ", Horário: " + agendamento.getHorário() + ", Paciente: " + agendamento.getPaciente().getNome() + ", Médico: " + agendamento.getMedicoResponsável().getNome());
                    }
                    int agendamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Agendamento agendamento = agendamentos.get(agendamentoIndex);

                    System.out.print("Status da Consulta (AGENDADA, CANCELADA, REALIZADA): ");
                    String status = scanner.nextLine();

                    List<Exame> examesPrescritos = new ArrayList<>();
                    List<Medicamento> medicamentosPrescritos = new ArrayList<>();

                    Consulta consulta = new Consulta(agendamento, status, examesPrescritos, medicamentosPrescritos, 0, null);
                    consultas.add(consulta);
                    agendamento.getPaciente().getHistorico().getConsultas()[consultas.size() - 1] = consulta;
                    agendamento.getMedicoResponsável().getHistorico().getConsultas()[consultas.size() - 1] = consulta;
                    System.out.println("Consulta criada com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Consulta
                    System.out.println("Selecione a Consulta: ");
                    for (int i = 0; i < consultas.size(); i++) {
                        Consulta consulta = consultas.get(i);
                        System.out.println((i + 1) + ". Data: " + consulta.getAgendamento().getData() + ", Horário: " + consulta.getAgendamento().getHorário() + ", Paciente: " + consulta.getAgendamento().getPaciente().getNome() + ", Médico: " + consulta.getAgendamento().getMedicoResponsável().getNome() + ", Status: " + consulta.getStatus());
                    }
                    int consultaIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Consulta consulta = consultas.get(consultaIndex);
                    consulta.lerConsulta();
                } else if (subEscolha == 3) {
                    // Atualizar Consulta
                    System.out.println("Selecione a Consulta: ");
                    for (int i = 0; i < consultas.size(); i++) {
                        Consulta consulta = consultas.get(i);
                        System.out.println((i + 1) + ". Data: " + consulta.getAgendamento().getData() + ", Horário: " + consulta.getAgendamento().getHorário() + ", Paciente: " + consulta.getAgendamento().getPaciente().getNome() + ", Médico: " + consulta.getAgendamento().getMedicoResponsável().getNome() + ", Status: " + consulta.getStatus());
                    }
                    int consultaIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Consulta consulta = consultas.get(consultaIndex);

                    System.out.print("Novo Status da Consulta (AGENDADA, CANCELADA, REALIZADA): ");
                    String novoStatus = scanner.nextLine();
                    System.out.print("Novo Valor da Consulta: ");
                    int novoValor = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    consulta.setStatus(novoStatus);
                    consulta.setValor(novoValor);
                    System.out.println("Consulta atualizada com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Consulta
                    System.out.println("Selecione a Consulta: ");
                    for (int i = 0; i < consultas.size(); i++) {
                        Consulta consulta = consultas.get(i);
                        System.out.println((i + 1) + ". Data: " + consulta.getAgendamento().getData() + ", Horário: " + consulta.getAgendamento().getHorário() + ", Paciente: " + consulta.getAgendamento().getPaciente().getNome() + ", Médico: " + consulta.getAgendamento().getMedicoResponsável().getNome() + ", Status: " + consulta.getStatus());
                    }
                    int consultaIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Consulta consulta = consultas.get(consultaIndex);

                    // Removendo a consulta dos históricos
                    for (int i = 0; i < consulta.getAgendamento().getPaciente().getHistorico().getConsultas().length; i++) {
                        if (consulta.getAgendamento().getPaciente().getHistorico().getConsultas()[i] == consulta) {
                            consulta.getAgendamento().getPaciente().getHistorico().getConsultas()[i] = null;
                            break;
                        }
                    }
                    for (int i = 0; i < consulta.getAgendamento().getMedicoResponsável().getHistorico().getConsultas().length; i++) {
                        if (consulta.getAgendamento().getMedicoResponsável().getHistorico().getConsultas()[i] == consulta) {
                            consulta.getAgendamento().getMedicoResponsável().getHistorico().getConsultas()[i] = null;
                            break;
                        }
                    }

                    consultas.remove(consultaIndex);
                    System.out.println("Consulta deletada com sucesso!");
                }
            }
            else if (escolha == 5) {
                // Funcionalidades de Prescrição
                System.out.println("5.1. Criar Prescrição");
                System.out.println("5.2. Ler Prescrição");
                System.out.println("5.3. Atualizar Prescrição");
                System.out.println("5.4. Deletar Prescrição");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Criar Prescrição
                    if (consultas.isEmpty()) {
                        System.out.println("É necessário ter pelo menos uma consulta para criar uma prescrição.");
                        continue;
                    }

                    System.out.println("Selecione a Consulta: ");
                    for (int i = 0; i < consultas.size(); i++) {
                        Consulta consulta = consultas.get(i);
                        System.out.println((i + 1) + ". Data: " + consulta.getAgendamento().getData() + ", Horário: " + consulta.getAgendamento().getHorário() + ", Paciente: " + consulta.getAgendamento().getPaciente().getNome() + ", Médico: " + consulta.getAgendamento().getMedicoResponsável().getNome() + ", Status: " + consulta.getStatus());
                    }
                    int consultaIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Consulta consulta = consultas.get(consultaIndex);

                    System.out.print("Tipo de Prescrição (Exame/Medicamento): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Data da Prescrição (DD/MM/AAAA): ");
                    String dataPrescrição = scanner.nextLine();
                    System.out.print("Data de Realização (DD/MM/AAAA): ");
                    String dataRealizacao = scanner.nextLine();
                    System.out.print("Data de Validade (DD/MM/AAAA): ");
                    String dataValidade = scanner.nextLine();
                    System.out.print("Custo: ");
                    int custo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Exame exame = new Exame(tipo, dataPrescrição, dataRealizacao, "", dataValidade, custo);
                    Medicamento medicamento = new Medicamento("Medicamento Exemplo");
                    Prescricao prescrição = new Prescricao(tipo, dataPrescrição, dataRealizacao, dataValidade, medicamento.getNomeMedicamento(), consulta, custo);

                    prescrições.add(prescrição);
                    consulta.setPrescriçãoAssociada(prescrição);
                    consulta.getAgendamento().getPaciente().getHistorico().setExames(new Exame[] {exame});
                    consulta.getAgendamento().getMedicoResponsável().getHistorico().setExames(new Exame[] {exame});

                    System.out.println("Prescrição criada com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Prescrição
                    System.out.println("Selecione a Prescrição: ");
                    for (int i = 0; i < prescrições.size(); i++) {
                        Prescricao prescrição = prescrições.get(i);
                        System.out.println((i + 1) + ". Tipo: " + prescrição.getTipo() + ", Data da Prescrição: " + prescrição.getDataPrescrição() + ", Consulta Associada: Data: " + prescrição.getConsultaAssociada().getAgendamento().getData() + ", Paciente: " + prescrição.getConsultaAssociada().getAgendamento().getPaciente().getNome());
                    }
                    int prescricaoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Prescricao prescrição = prescrições.get(prescricaoIndex);
                    System.out.println("Tipo: " + prescrição.getTipo());
                    System.out.println("Data da Prescrição: " + prescrição.getDataPrescrição());
                    System.out.println("Data de Realização: " + prescrição.getDataRealização());
                    System.out.println("Data de Validade: " + prescrição.getDataValidade());
                    System.out.println("Consulta Associada: Data: " + prescrição.getConsultaAssociada().getAgendamento().getData() + ", Paciente: " + prescrição.getConsultaAssociada().getAgendamento().getPaciente().getNome());
                    System.out.println("Custo: " + prescrição.getCusto());
                } else if (subEscolha == 3) {
                    // Atualizar Prescrição
                    System.out.println("Selecione a Prescrição: ");
                    for (int i = 0; i < prescrições.size(); i++) {
                        Prescricao prescrição = prescrições.get(i);
                        System.out.println((i + 1) + ". Tipo: " + prescrição.getTipo() + ", Data da Prescrição: " + prescrição.getDataPrescrição() + ", Consulta Associada: Data: " + prescrição.getConsultaAssociada().getAgendamento().getData() + ", Paciente: " + prescrição.getConsultaAssociada().getAgendamento().getPaciente().getNome());
                    }
                    int prescricaoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Prescricao prescrição = prescrições.get(prescricaoIndex);

                    System.out.print("Novo Tipo de Prescrição (Exame/Medicamento): ");
                    String novoTipo = scanner.nextLine();
                    System.out.print("Nova Data da Prescrição (DD/MM/AAAA): ");
                    String novaDataPrescrição = scanner.nextLine();
                    System.out.print("Nova Data de Realização (DD/MM/AAAA): ");
                    String novaDataRealizacao = scanner.nextLine();
                    System.out.print("Nova Data de Validade (DD/MM/AAAA): ");
                    String novaDataValidade = scanner.nextLine();
                    System.out.print("Novo Custo: ");
                    int novoCusto = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    prescrição.setTipo(novoTipo);
                    prescrição.setDataPrescrição(novaDataPrescrição);
                    prescrição.setDataRealização(novaDataRealizacao);
                    prescrição.setDataValidade(novaDataValidade);
                    prescrição.setCusto(novoCusto);
                    System.out.println("Prescrição atualizada com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Prescrição
                    System.out.println("Selecione a Prescrição: ");
                    for (int i = 0; i < prescrições.size(); i++) {
                        Prescricao prescrição = prescrições.get(i);
                        System.out.println((i + 1) + ". Tipo: " + prescrição.getTipo() + ", Data da Prescrição: " + prescrição.getDataPrescrição() + ", Consulta Associada: Data: " + prescrição.getConsultaAssociada().getAgendamento().getData() + ", Paciente: " + prescrição.getConsultaAssociada().getAgendamento().getPaciente().getNome());
                    }
                    int prescricaoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Prescricao prescrição = prescrições.get(prescricaoIndex);

                    // Remover a prescrição da consulta associada
                    Consulta consulta = prescrição.getConsultaAssociada();
                    consulta.setPrescriçãoAssociada(null);

                    // Remover a prescrição da lista
                    prescrições.remove(prescricaoIndex);
                    System.out.println("Prescrição deletada com sucesso!");
                }
            } 

            else if (escolha == 6) {
                // Funcionalidades de Medicamento
                System.out.println("6.1. Adicionar Medicamento");
                System.out.println("6.2. Ler Medicamento");
                System.out.println("6.3. Atualizar Medicamento");
                System.out.println("6.4. Deletar Medicamento");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Adicionar Medicamento
                    System.out.print("Nome do Medicamento: ");
                    String nomeMedicamento = scanner.nextLine();

                    Medicamento medicamento = new Medicamento(nomeMedicamento);
                    medicamentos.add(medicamento);
                    System.out.println("Medicamento adicionado com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Medicamento
                    System.out.println("Selecione o Medicamento: ");
                    for (int i = 0; i < medicamentos.size(); i++) {
                        Medicamento medicamento = medicamentos.get(i);
                        System.out.println((i + 1) + ". Nome: " + medicamento.getNomeMedicamento());
                    }
                    int medicamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Medicamento medicamento = medicamentos.get(medicamentoIndex);
                    medicamento.lerMedicamento();
                } else if (subEscolha == 3) {
                    // Atualizar Medicamento
                    System.out.println("Selecione o Medicamento: ");
                    for (int i = 0; i < medicamentos.size(); i++) {
                        Medicamento medicamento = medicamentos.get(i);
                        System.out.println((i + 1) + ". Nome: " + medicamento.getNomeMedicamento());
                    }
                    int medicamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Medicamento medicamento = medicamentos.get(medicamentoIndex);

                    System.out.print("Novo Nome do Medicamento: ");
                    String novoNomeMedicamento = scanner.nextLine();
                    medicamento.setNomeMedicamento(novoNomeMedicamento);
                    System.out.println("Medicamento atualizado com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Medicamento
                    System.out.println("Selecione o Medicamento: ");
                    for (int i = 0; i < medicamentos.size(); i++) {
                        Medicamento medicamento = medicamentos.get(i);
                        System.out.println((i + 1) + ". Nome: " + medicamento.getNomeMedicamento());
                    }
                    int medicamentoIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    medicamentos.remove(medicamentoIndex);
                    System.out.println("Medicamento deletado com sucesso!");
                }
            }
            else if (escolha == 7) {
                // Funcionalidades de Exame
                System.out.println("7.1. Adicionar Exame");
                System.out.println("7.2. Ler Exame");
                System.out.println("7.3. Atualizar Exame");
                System.out.println("7.4. Deletar Exame");
                System.out.print("Escolha uma opção: ");
                int subEscolha = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer

                if (subEscolha == 1) {
                    // Adicionar Exame
                    System.out.print("Tipo de Exame: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Data da Prescrição (DD/MM/AAAA): ");
                    String dataPrescrição = scanner.nextLine();
                    System.out.print("Data de Realização (DD/MM/AAAA): ");
                    String dataRealizacao = scanner.nextLine();
                    System.out.print("Data de Validade (DD/MM/AAAA): ");
                    String dataValidade = scanner.nextLine();
                    System.out.print("Custo: ");
                    int custo = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Exame exame = new Exame(tipo, dataPrescrição, dataRealizacao, "", dataValidade, custo);
                    exames.add(exame);
                    System.out.println("Exame adicionado com sucesso!");
                } else if (subEscolha == 2) {
                    // Ler Exame
                    System.out.println("Selecione o Exame: ");
                    for (int i = 0; i < exames.size(); i++) {
                        Exame exame = exames.get(i);
                        System.out.println((i + 1) + ". Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescrição() + ", Data de Realização: " + exame.getDataRealização() + ", Data de Validade: " + exame.getDataValidade() + ", Custo: " + exame.getCusto());
                    }
                    int exameIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Exame exame = exames.get(exameIndex);
                    exame.lerExame();
                } else if (subEscolha == 3) {
                    // Atualizar Exame
                    System.out.println("Selecione o Exame: ");
                    for (int i = 0; i < exames.size(); i++) {
                        Exame exame = exames.get(i);
                        System.out.println((i + 1) + ". Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescrição() + ", Data de Realização: " + exame.getDataRealização() + ", Data de Validade: " + exame.getDataValidade() + ", Custo: " + exame.getCusto());
                    }
                    int exameIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    Exame exame = exames.get(exameIndex);

                    System.out.print("Novo Tipo de Exame: ");
                    String novoTipo = scanner.nextLine();
                    System.out.print("Nova Data da Prescrição (DD/MM/AAAA): ");
                    String novaDataPrescrição = scanner.nextLine();
                    System.out.print("Nova Data de Realização (DD/MM/AAAA): ");
                    String novaDataRealizacao = scanner.nextLine();
                    System.out.print("Nova Data de Validade (DD/MM/AAAA): ");
                    String novaDataValidade = scanner.nextLine();
                    System.out.print("Novo Custo: ");
                    int novoCusto = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    exame.setTipo(novoTipo);
                    exame.setDataPrescrição(novaDataPrescrição);
                    exame.setDataRealização(novaDataRealizacao);
                    exame.setDataValidade(novaDataValidade);
                    exame.setCusto(novoCusto);
                    System.out.println("Exame atualizado com sucesso!");
                } else if (subEscolha == 4) {
                    // Deletar Exame
                    System.out.println("Selecione o Exame: ");
                    for (int i = 0; i < exames.size(); i++) {
                        Exame exame = exames.get(i);
                        System.out.println((i + 1) + ". Tipo: " + exame.getTipo() + ", Data da Prescrição: " + exame.getDataPrescrição() + ", Data de Realização: " + exame.getDataRealização() + ", Data de Validade: " + exame.getDataValidade() + ", Custo: " + exame.getCusto());
                    }
                    int exameIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Limpar o buffer
                    exames.remove(exameIndex);
                    System.out.println("Exame deletado com sucesso!");
                }
            }
            else if (escolha == 8) {
                System.out.println("Saindo do sistema. Até logo!");
                break;
            }
        }
        scanner.close();
    }
}




            
            
            
                    




