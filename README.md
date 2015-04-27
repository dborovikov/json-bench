# Scala JSON libs benchmark using JMH

Run:

    sbt run

Example output:

    [info] Benchmark                Mode  Cnt      Score       Error  Units
    [info] MarshallBench.argonaut  thrpt    5  32649.071 ±  1203.992  ops/s
    [info] MarshallBench.jackson   thrpt    5  85938.608 ± 11273.654  ops/s
    [info] MarshallBench.play      thrpt    5  21378.851 ±   957.831  ops/s
    [info] MarshallBench.spray     thrpt    5  59801.193 ±  3412.802  ops/s
    [info] ParseBench.argonaut     thrpt    5  22249.704 ±  1255.345  ops/s
    [info] ParseBench.jackson      thrpt    5  71755.857 ±  6628.053  ops/s
    [info] ParseBench.jawn         thrpt    5  56044.377 ±  2192.962  ops/s
    [info] ParseBench.play         thrpt    5  23323.652 ±  1186.733  ops/s
    [info] ParseBench.spray        thrpt    5  51767.834 ±   947.548  ops/s
