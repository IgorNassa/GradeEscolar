# Sistema de Gestão e Otimização de Horários Escolares (JAVA)
Projeto desenvolvido em Java puro com Maven, voltado para a gestão e criação de horários escolares. O sistema simplifica a alocação de Professores, Turmas e Grades, assegurando compatibilidade entre recursos e evitando conflitos. A interface pode ser executada direto na IDE. 🧭

Visão geral 🧐
Objetivo: gerar horários otimizados para disciplinas, docentes e salas, evitando sobreposições e respeitando restrições de disponibilidade e preferências.

Entidades principais: Professor, Turma, Grade.

Funcionalidades-chave (sem necessidade de configuração de testes/relatórios):
Alocação automática de horários com validação de conflitos. 🔄
Gerenciamento de recursos (professores, disciplinas, turmas, salas). 🗂️
Visualização e edição manuais da grade horária. ✍️
Exportação/importação simples (se houver necessidade, pode-se estender posteriormente). ⬇️⬆️

Tecnologias 🧰

Linguagem: Java (versão alvo: 11+) 🟨
Build: Maven Maven

GUI: Java puro (Swing ou JavaFX conforme escolha no projeto) 🖥️

Persistência: via JDBC para o banco de dados de sua escolha (ex.: PostgreSQL / MySQL) ou persistência baseada em arquivos (JSON/CSV) se assim preferir. 💾

Dependências e versões 🧩
Maven (configurar no environment de build)
Observação: não há dependências externas obrigatórias listadas neste momento; ajuste conforme o seu setup real.
Instalação e execução 🚀
Requisitos:

JDK 11+ instalado
Maven configurado
Ambiente com acesso ao banco de dados (se usar persistência DB)
Passos (executáveis na IDE ou via linha de comando):

Clonar o repositório (ajuste conforme seu repositório):
git clone https://seu-repositorio-url
cd nome-do-projeto
Construção com Maven:
mvn clean package
Configuração (arquivo de propriedades a adaptar conforme seu ambiente):
src/main/resources/application.properties (ou outro caminho conforme sua implementação)
db.url=jdbc:seu-banco://host:porta/dbname
db.user=seuUsuario
db.password=suaSenha
app.gui.theme=default (opcional)
Execução:
pela IDE: abra o projeto e rode a classe principal (Main) correspondente ao entry point
pela linha de comando (exemplo):
java -jar target/nome-do-projeto-version.jar
Observação: se preferir, posso fornecer um exemplo concreto de classe Main e configuração de projeto. Diga o nome do pacote principal.

Configuração e uso ⚙️
Arquivo de configuração:
Fluxo de uso

Entidades principais:

Professor
Turma
Grade
Regras de alocação (a preencher): restrições de disponibilidade, preferência, capacidade de salas, etc.

Preferências de usuário:

Compatibilidade entre professor, turma e disciplina
Evitar conflitos de salas e docentes
Fluxo de uso permanece em branco para você preencher com diagramas posteriormente. 🗒️

Créditos 👏
Igor Almeida
Allan Hiran
Pedro Henrique
Bruno Vinicius
Pedro Henrique

Estrutura de dados (alto nível) 📊

Professor: id, nome, disponibilidade, restrições
Turma: id, curso, periodo, capacidade, disciplinas
Grade: estrutura de horários por dia/horário/bloco
Regras de alocação (a preencher conforme implementação)
