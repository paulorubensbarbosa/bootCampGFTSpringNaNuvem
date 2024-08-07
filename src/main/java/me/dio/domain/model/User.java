package me.dio.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne( cascade = CascadeType.ALL) // Cascade utilizado para que quando um usuário for deletado, a conta é deletada junto visando o forte relacionamento no BD
    private Account account;

    @OneToOne( cascade = CascadeType.ALL)
    private Card card;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER) // Eager toda vez que buscar um usuário no banco, sempre buscar toda sua lista de features, pois nesse contexto sempre iremos precisar das features
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
