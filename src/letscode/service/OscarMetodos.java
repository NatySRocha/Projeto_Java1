package com.letscode.service;



import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OscarMetodos {

    //    Quem foi o ator mais jovem a ganhar um Oscar?
    public static String getAtorMaisJovemGanharOscar(List<OscarWinner> maleList){
        return maleList.stream()
                .min(Comparator.comparingInt(OscarWinner::getAge))
                .get().getName();
    }

    //    Quem foi a atriz que mais vezes foi premiada?
    public static String getAtrizMaisVezPremiada(List<OscarWinner> femaleList){
        return
                femaleList.stream()
                        .collect(groupingBy(OscarWinner::getName, counting()))
                        .entrySet()
                        .stream().max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                        .get()
                        .getKey();
    }

    //    Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a).
    public static void getTudoSobreAPessoa (List<OscarWinner> personList, String name) {
        System.out.println("Quando informado o nome de um ator ou atriz, dê um resumo de quantos prêmios ele/ela recebeu e liste ano, idade e nome de cada filme pelo qual foi premiado(a)");
        double quantidadeDeVezesPremiado = personList.stream().filter(OscarWinner -> OscarWinner.getName().contains(name)).count();
        if (quantidadeDeVezesPremiado != 0) {
            System.out.println(name + " foi premiado(a) " + quantidadeDeVezesPremiado + " vezes.\nResumo dos prêmios: ");
            personList.stream()
                    .filter(OscarWinner -> OscarWinner.getName().contains(name))
                    .forEach(OscarWinner -> {
                        System.out.println("Ano: " + OscarWinner.getYear() + " Idade: " + OscarWinner.getAge() + " Filme:" + OscarWinner.getMovie());
                    });
        }
        else {
            System.out.println(name + " nunca recebeu o Oscar");
        }
    }

    //  Quais atores ou atrizes receberam mais de um Oscar? Elabore uma única estrutura contendo atores e atrizes.
    public static void getAtoresQueReceberamMaisDeUmOscar (List<OscarWinner> allOscarWinnerList) {
        Stream<String> listaNomes = allOscarWinnerList.stream().map(OscarWinner::getName);

        Map<String, Long> countedMale = listaNomes.collect(groupingBy(Function.identity(), counting()));
        System.out.println("Atores e atrizes que receberam mais de um Oscar:");
        countedMale.forEach((x, y) -> {
            if (y > 1) {
                System.out.println("Ator: " + x + " - Quantidade de premios: " + y);
            }
        });
    }

    //  Qual atriz entre 20 e 30 anos que mais vezes foi vencedora?
    public static String getAtrizEntreIdades(List<OscarWinner> femaleList){
        return
                femaleList.stream()
                        .filter(OscarWinner -> OscarWinner.getAge() > 20 && OscarWinner.getAge() < 30)
                        .collect(groupingBy(OscarWinner::getName, counting()))
                        .entrySet()
                        .stream().max((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                        .get()
                        .getKey();
    }
}