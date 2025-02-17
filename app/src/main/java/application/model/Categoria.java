package application.model; // Define o pacote onde esta classe está localizada

import java.util.HashSet; // Importação desnecessária, pois não está sendo utilizada
import java.util.Set; // Importação desnecessária, pois não está sendo utilizada

// Importa anotações do Jakarta Persistence para o mapeamento da entidade no banco de dados
import jakarta.persistence.Column;//	Define configurações da coluna no banco de dados
import jakarta.persistence.Entity;//	Marca a classe como uma entidade do banco de dados
import jakarta.persistence.Id;//	Define um campo como chave primária
import jakarta.persistence.Table;//	Personaliza o nome da tabela no banco de dados
import jakarta.persistence.GenerationType;//	Define a estratégia para gerar o ID automaticamente
import jakarta.persistence.GeneratedValue;//	Faz com que o ID seja gerado automaticamente
import jakarta.persistence.OneToMany;//	Define um relacionamento um-para-muitos entre entidades


@Entity // Indica que esta classe é uma entidade do banco de dados
@Table(name = "categorias") // Define o nome da tabela no banco de dados
public class Categoria { // Declara a classe Categoria, que representa uma categoria no banco de dados

    @Id // Define que o campo "id" será a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do "id" será gerado automaticamente pelo banco de dados (autoincremento) 
    private long id; // Declara o atributo "id" do tipo long para armazenar o identificador único da categoria
    
    @Column(unique = true, nullable = false) // Define que a coluna "nome" deve ser única e não pode ser nula
    private String nome; // Declara o atributo "nome" do tipo String para armazenar o nome da categoria

    @OneToMany(mappedBy = "categoria")
    private Set<Jogo> Jogos = new HashSet<>();

    public long getID(){
        return id;
    }

    public void setId(long id) {
    this.id = id;
    }

    public String getNome() {
    return nome;
    }

    public void setNome (String nome) {
    this.nome = nome;
    }
    
    public Set<Jogo> getJogos() {
    return jogos;
    }

    public void setJogos (Set<Jogo> jogos) {
    this.jogos = jogos;
    }

}

