---
title: Builder
category: Creational
language: en
tag:
 - Gang of Four
---

## Intenção

Separe a construção de um objeto complexo da sua representação para que a mesma construção
processo pode criar diferentes representações.

## Explicação

Exemplo do mundo real

> Imagine um gerador de personagens para um RPG. A opção mais fácil é deixar o computador
> crie o personagem para você. Se você quiser selecionar manualmente os detalhes do personagem como
> profissão, gênero, cor do cabelo, etc. a geração do personagem se torna um processo passo a passo que
> é concluído quando todas as seleções estiverem prontas.

Em palavras simples

> Permite criar diferentes sabores de um objeto, evitando a poluição do construtor. Útil
> quando pode haver vários sabores de um objeto. Ou quando há muitas etapas envolvidas no
> criação de um objeto.

Wikipédia diz

> O padrão construtor é um padrão de design de software de criação de objetos com a intenção de encontrar
> uma solução para o antipadrão do construtor telescópico.

Dito isto, deixe-me acrescentar um pouco sobre o que é o antipadrão do construtor telescópico. Em um ponto
ou outro, todos nós vimos um construtor como abaixo:

```java
public Livro(Autor autor, String titulo, Subtitulo subtitulo, Editora editora, Datapublicacao datapublicacao) {
}
```

Como você pode ver, o número de parâmetros do construtor pode rapidamente sair do controle e pode se tornar
difícil entender a disposição dos parâmetros. Além disso, esta lista de parâmetros poderia continuar
crescendo se você quiser adicionar mais opções no futuro. Isso é chamado de construtor telescópico
anti-padrão.

**Exemplo programático**

A alternativa sensata é usar o padrão Builder. Em primeiro lugar, temos o nosso livro que queremos
criar:

```java
public final class Livro {
  private final Autor autor;
  private final String titulo;
  private final Subtitulo subtitulo;
  private final Editora editora;
  private final Datapublicacao datapublicacao;

  private Livro(Builder builder) {
    this.autor = builder.autor;
    this.titulo = builder.titulo;
    this.subtitulo = builder.subtitulo;
    this.editora = builder.editora;
    this.datapublicacao = builder.datapublicacao;
  }
}
```

Então temos o builder:

```java
  public static class Builder {
    private final Autor autor;
    private final String titulo;
    private Subtitulo subtitulo;
    private Editora editora;
    private Datapublicacao datapublicacao;

    public Builder(Autor autor, String titulo) {
      if (autor == null || titulo == null) {
        throw new IllegalArgumentException("autor e titulo não podem ser nulos");
      }
      this.autor = autor;
      this.titulo = titulo;
    }

    public Builder comSubtitulo(Subtitulo subtitulo) {
      this.subtitulo = subtitulo;
      return this;
    }

    public Builder comEditora(Editora editora) {
      this.editora = editora;
      return this;
    }

    public Builder comDatapublicacao(Datapublicacao datapublicacao) {
      this.datapublicacao = datapublicacao;
      return this;
    }

    public Livro build() {
      return new Livro(this);
    }
  }
```

Então pode ser usado assim:

```java
var Clarice = new Livro.Builder(Autor.ClariceLispector, "Clarice").comEditora(Editora.ROCCO).comDatapublicacao(Datapublicacao.1997).build();
```

## Diagrama de Classe

![alt text](./etc/builder.urm.png "Builder class diagram")

## Aplicabilidade

Use o padrão Builder quando

* O algoritmo para criação de um objeto complexo deve ser independente das partes que compõem o objeto e de como elas são montadas
* O processo de construção deve permitir diferentes representações para o objeto que se constrói


