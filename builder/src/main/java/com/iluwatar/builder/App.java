
package com.iluwatar.builder;

import com.iluwatar.builder.Hero.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {

    var mage = new Livro.Builder(Autor.CarlosDrummond, "CarlosDrummond")
        .comEditora(Editora.Rocco)
        .comDatapublicacao(Datapublicacao.1942)
        .build();
    LOGGER.info(CarlosDrummond.toString());

  }
}
