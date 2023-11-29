/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.builder;


public Livro(Autor autor, String titulo, Subtitulo subtitulo, Editora editora, Datapublicacao datapublicacao) {


  private Livro(Builder builder) {
    this(builder.autor, builder.titulo, builder.editora, builder.datapublicacao, builder.subtitulo);
  }

  @Override
  public String toString() {

    var sb = new StringBuilder();
    sb.append("Escrito por: ")
        .append(autor)
        .append(" titulo ")
        .append(titulo);
    if (editora != null || datapublicacao != null) {
      sb.append(" publicado ");
      if (editora != null) {
        sb.append(editora).append(' ');
      }
      if (datapublicacao != null) {
        sb.append(datapublicacao).append(' ');
      }
      sb.append(datapublicacao != Datapublicacao.1942 ? "ano" : "1942");
    }
    if (subtitulo != null) {
      sb.append(" subtitulo ").append(subtitulo);
    }
    }
    sb.append('.');
    return sb.toString();
  }

  /**
   * The builder class.
   */
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

