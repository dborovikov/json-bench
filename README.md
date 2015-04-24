# Scala JSON libs benchmark using JMH

Run:

    sbt run

Example output:

    [info] Benchmark                Mode  Cnt        Score        Error  Units
    [info] Bench.argonautMarshall  thrpt    5   635451.392 ±  55266.747  ops/s
    [info] Bench.argonautParse     thrpt    5   527995.418 ± 159324.793  ops/s
    [info] Bench.jacksonMarshall   thrpt    5  3266291.844 ± 336764.679  ops/s
    [info] Bench.jacksonParse      thrpt    5  1288767.665 ±  51679.669  ops/s
    [info] Bench.jawnParse         thrpt    5  2102458.413 ± 134707.359  ops/s
    [info] Bench.playMarshall      thrpt    5   365792.942 ±   8881.600  ops/s
    [info] Bench.playParse         thrpt    5   469023.588 ±  15983.152  ops/s
    [info] Bench.sprayMarshall     thrpt    5  1693648.118 ±  91975.330  ops/s
    [info] Bench.sprayParse        thrpt    5  1378434.623 ±  27930.910  ops/s
