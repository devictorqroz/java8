package com.devictor.java8.multithread.threadsandrunnable;

public class ThreadsAndRunnable {

    public static void main(String[] args) {

        // ### Thread atual
        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        MeuRunnable meuRunnable = new MeuRunnable();


        // ### Nova thread

        // Thread t1 = new Thread();
        // Nesse ponto ainda não criamos uma nova thread (linha de execuçã).
        // Criamos um objeto que representa uma nova Thread.


        Thread t1 = new Thread(meuRunnable);
        //t1.run();
        // método MeuRunnable.run() imprime o nome da thread atual
        // t1 continua rodando na thread 'main'


        // Pedimos para a JVM chamar o método t1.run() assim que ela puder.
        // não é garantida a execução naquele exato milissegundo.

        // t1.start();
        // t1.run(); = apenas executando na mesma thread.
        // t1.start(); = executando em uma nova thread (Thread-0).


        // ### Runnable como lambda
        // executando na Thread-1
        Thread t2 = new Thread(
            () -> System.out.println(Thread.currentThread().getName()));

        // t2.start();
        // t2.start();
        // Lança uma exception, não se pode iniciar 2x a mesma Thread.
        // Se desejar executar 2x a mesma coisa é preciso criar outra Thread.

        // Não posso chamar o 'start()' mais de uma vez na mesma Thread.
        // Mas posso executar o mesmo Runnable 'MeuRunnable' mais de uma vez.
        // Cada execução utilizando uma nova implementação.
        // Podendo utilizar a mesma instância de um Runnable.


        // ### Várias Threads
        Thread t3 = new Thread(meuRunnable);

        // Linhas de execução paralelas
        t1.start();
        t2.start();
        t3.start();


    }

}
