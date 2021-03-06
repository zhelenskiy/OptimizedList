Yet another implementation of eager list operations.

It uses mutable state to illuminate creating intermediate lists.

---
Results:

```
Benchmark                                    (n)  (operations)  Mode  Cnt       Score        Error  Units
Benchmarks.mapIntList                          1             1  avgt    4      17.535 ±      5.895  ns/op
Benchmarks.mapIntList                          1             2  avgt    4      33.992 ±      1.983  ns/op
Benchmarks.mapIntList                          1             5  avgt    4      67.365 ±     37.010  ns/op
Benchmarks.mapIntList                          1            10  avgt    4     149.360 ±     17.996  ns/op
Benchmarks.mapIntList                         10             1  avgt    4     109.333 ±      1.418  ns/op
Benchmarks.mapIntList                         10             2  avgt    4     183.474 ±      4.473  ns/op
Benchmarks.mapIntList                         10             5  avgt    4     477.458 ±     19.553  ns/op
Benchmarks.mapIntList                         10            10  avgt    4     881.940 ±     49.473  ns/op
Benchmarks.mapIntList                        100             1  avgt    4    1012.561 ±     33.761  ns/op
Benchmarks.mapIntList                        100             2  avgt    4    1723.244 ±    216.766  ns/op
Benchmarks.mapIntList                        100             5  avgt    4    3834.257 ±    750.222  ns/op
Benchmarks.mapIntList                        100            10  avgt    4    7451.568 ±    556.462  ns/op
Benchmarks.mapIntList                       1000             1  avgt    4    9874.562 ±    322.038  ns/op
Benchmarks.mapIntList                       1000             2  avgt    4   16843.352 ±   1567.846  ns/op
Benchmarks.mapIntList                       1000             5  avgt    4   37005.271 ±   1935.560  ns/op
Benchmarks.mapIntList                       1000            10  avgt    4   70567.907 ±   1281.530  ns/op
Benchmarks.mapIntList                      10000             1  avgt    4  101122.702 ±   5317.894  ns/op
Benchmarks.mapIntList                      10000             2  avgt    4  166256.229 ±   3719.575  ns/op
Benchmarks.mapIntList                      10000             5  avgt    4  388032.649 ±  97541.768  ns/op
Benchmarks.mapIntList                      10000            10  avgt    4  715465.831 ±  59815.601  ns/op
Benchmarks.mapIntOptimizedList                 1             1  avgt    4      28.778 ±      2.670  ns/op
Benchmarks.mapIntOptimizedList                 1             2  avgt    4      30.018 ±     27.044  ns/op
Benchmarks.mapIntOptimizedList                 1             5  avgt    4      49.967 ±     51.979  ns/op
Benchmarks.mapIntOptimizedList                 1            10  avgt    4      90.493 ±     27.170  ns/op
Benchmarks.mapIntOptimizedList                10             1  avgt    4     121.962 ±     59.478  ns/op
Benchmarks.mapIntOptimizedList                10             2  avgt    4     179.161 ±      1.042  ns/op
Benchmarks.mapIntOptimizedList                10             5  avgt    4     374.733 ±     13.154  ns/op
Benchmarks.mapIntOptimizedList                10            10  avgt    4     686.466 ±     20.070  ns/op
Benchmarks.mapIntOptimizedList               100             1  avgt    4     988.299 ±     15.531  ns/op
Benchmarks.mapIntOptimizedList               100             2  avgt    4    1704.256 ±    100.167  ns/op
Benchmarks.mapIntOptimizedList               100             5  avgt    4    3436.208 ±    100.004  ns/op
Benchmarks.mapIntOptimizedList               100            10  avgt    4    6054.192 ±    190.596  ns/op
Benchmarks.mapIntOptimizedList              1000             1  avgt    4    9793.646 ±    128.764  ns/op
Benchmarks.mapIntOptimizedList              1000             2  avgt    4   16202.884 ±   3585.476  ns/op
Benchmarks.mapIntOptimizedList              1000             5  avgt    4   35673.666 ±   7826.228  ns/op
Benchmarks.mapIntOptimizedList              1000            10  avgt    4   67442.018 ±    811.655  ns/op
Benchmarks.mapIntOptimizedList             10000             1  avgt    4  102668.731 ±  12943.003  ns/op
Benchmarks.mapIntOptimizedList             10000             2  avgt    4  166415.941 ±   8155.453  ns/op
Benchmarks.mapIntOptimizedList             10000             5  avgt    4  357730.899 ±  17048.410  ns/op
Benchmarks.mapIntOptimizedList             10000            10  avgt    4  676982.830 ±  17504.378  ns/op
Benchmarks.mapIntPreparedOptimizedList         1             1  avgt    4      12.539 ±      1.775  ns/op
Benchmarks.mapIntPreparedOptimizedList         1             2  avgt    4      19.440 ±      0.525  ns/op
Benchmarks.mapIntPreparedOptimizedList         1             5  avgt    4      39.626 ±      1.003  ns/op
Benchmarks.mapIntPreparedOptimizedList         1            10  avgt    4      74.428 ±      6.290  ns/op
Benchmarks.mapIntPreparedOptimizedList        10             1  avgt    4     103.733 ±     39.920  ns/op
Benchmarks.mapIntPreparedOptimizedList        10             2  avgt    4     164.645 ±     87.430  ns/op
Benchmarks.mapIntPreparedOptimizedList        10             5  avgt    4     356.240 ±    185.101  ns/op
Benchmarks.mapIntPreparedOptimizedList        10            10  avgt    4     674.280 ±    311.665  ns/op
Benchmarks.mapIntPreparedOptimizedList       100             1  avgt    4    1018.180 ±    513.508  ns/op
Benchmarks.mapIntPreparedOptimizedList       100             2  avgt    4    1629.175 ±   1064.482  ns/op
Benchmarks.mapIntPreparedOptimizedList       100             5  avgt    4    3630.659 ±   2409.198  ns/op
Benchmarks.mapIntPreparedOptimizedList       100            10  avgt    4    6487.315 ±   5570.703  ns/op
Benchmarks.mapIntPreparedOptimizedList      1000             1  avgt    4   13462.910 ±   6183.638  ns/op
Benchmarks.mapIntPreparedOptimizedList      1000             2  avgt    4   23546.535 ±   9257.335  ns/op
Benchmarks.mapIntPreparedOptimizedList      1000             5  avgt    4   53088.351 ±  27487.028  ns/op
Benchmarks.mapIntPreparedOptimizedList      1000            10  avgt    4  102545.911 ±  58260.582  ns/op
Benchmarks.mapIntPreparedOptimizedList     10000             1  avgt    4  139892.741 ±  45851.268  ns/op
Benchmarks.mapIntPreparedOptimizedList     10000             2  avgt    4  243490.783 ±  14158.495  ns/op
Benchmarks.mapIntPreparedOptimizedList     10000             5  avgt    4  563281.538 ±  53508.352  ns/op
Benchmarks.mapIntPreparedOptimizedList     10000            10  avgt    4  990252.638 ± 109335.465  ns/op
Benchmarks.mapIntSequence                      1             1  avgt    4      16.981 ±      2.368  ns/op
Benchmarks.mapIntSequence                      1             2  avgt    4      27.647 ±      2.151  ns/op
Benchmarks.mapIntSequence                      1             5  avgt    4      70.007 ±      3.267  ns/op
Benchmarks.mapIntSequence                      1            10  avgt    4     141.885 ±      6.877  ns/op
Benchmarks.mapIntSequence                     10             1  avgt    4      76.137 ±     10.718  ns/op
Benchmarks.mapIntSequence                     10             2  avgt    4     117.415 ±      7.264  ns/op
Benchmarks.mapIntSequence                     10             5  avgt    4     317.588 ±     11.140  ns/op
Benchmarks.mapIntSequence                     10            10  avgt    4     671.163 ±     20.157  ns/op
Benchmarks.mapIntSequence                    100             1  avgt    4     666.397 ±     37.883  ns/op
Benchmarks.mapIntSequence                    100             2  avgt    4    1027.392 ±     32.766  ns/op
Benchmarks.mapIntSequence                    100             5  avgt    4    2692.449 ±     71.684  ns/op
Benchmarks.mapIntSequence                    100            10  avgt    4    5775.400 ±     79.336  ns/op
Benchmarks.mapIntSequence                   1000             1  avgt    4    6715.620 ±   1757.411  ns/op
Benchmarks.mapIntSequence                   1000             2  avgt    4   12221.701 ±    397.861  ns/op
Benchmarks.mapIntSequence                   1000             5  avgt    4   29482.277 ±    397.603  ns/op
Benchmarks.mapIntSequence                   1000            10  avgt    4   58981.073 ±    699.010  ns/op
Benchmarks.mapIntSequence                  10000             1  avgt    4   67688.873 ±  12847.968  ns/op
Benchmarks.mapIntSequence                  10000             2  avgt    4  123378.803 ±   6499.955  ns/op
Benchmarks.mapIntSequence                  10000             5  avgt    4  295046.668 ±  13391.791  ns/op
Benchmarks.mapIntSequence                  10000            10  avgt    4  586331.282 ±  14005.010  ns/op
Benchmarks.mapObjectList                       1             1  avgt    4      18.647 ±      3.311  ns/op
Benchmarks.mapObjectList                       1             2  avgt    4      30.542 ±      3.430  ns/op
Benchmarks.mapObjectList                       1             5  avgt    4      66.922 ±      8.455  ns/op
Benchmarks.mapObjectList                       1            10  avgt    4     131.102 ±      4.277  ns/op
Benchmarks.mapObjectList                      10             1  avgt    4      96.742 ±      5.217  ns/op
Benchmarks.mapObjectList                      10             2  avgt    4     159.216 ±      9.416  ns/op
Benchmarks.mapObjectList                      10             5  avgt    4     370.756 ±    166.129  ns/op
Benchmarks.mapObjectList                      10            10  avgt    4     689.247 ±    396.182  ns/op
Benchmarks.mapObjectList                     100             1  avgt    4     882.154 ±      5.025  ns/op
Benchmarks.mapObjectList                     100             2  avgt    4    1452.375 ±     30.995  ns/op
Benchmarks.mapObjectList                     100             5  avgt    4    3072.710 ±     40.004  ns/op
Benchmarks.mapObjectList                     100            10  avgt    4    6021.260 ±     68.829  ns/op
Benchmarks.mapObjectList                    1000             1  avgt    4    8886.592 ±   1022.908  ns/op
Benchmarks.mapObjectList                    1000             2  avgt    4   15272.470 ±    373.202  ns/op
Benchmarks.mapObjectList                    1000             5  avgt    4   33192.734 ±    276.329  ns/op
Benchmarks.mapObjectList                    1000            10  avgt    4   63588.994 ±   3916.146  ns/op
Benchmarks.mapObjectList                   10000             1  avgt    4   89889.329 ±    821.601  ns/op
Benchmarks.mapObjectList                   10000             2  avgt    4  151983.864 ±   6162.627  ns/op
Benchmarks.mapObjectList                   10000             5  avgt    4  332328.545 ±   2095.169  ns/op
Benchmarks.mapObjectList                   10000            10  avgt    4  632374.581 ±   3187.658  ns/op
Benchmarks.mapObjectOptimizedList              1             1  avgt    4      28.503 ±      1.570  ns/op
Benchmarks.mapObjectOptimizedList              1             2  avgt    4      33.740 ±      1.733  ns/op
Benchmarks.mapObjectOptimizedList              1             5  avgt    4      53.145 ±      5.729  ns/op
Benchmarks.mapObjectOptimizedList              1            10  avgt    4      84.150 ±      2.007  ns/op
Benchmarks.mapObjectOptimizedList             10             1  avgt    4     112.199 ±     13.186  ns/op
Benchmarks.mapObjectOptimizedList             10             2  avgt    4     175.068 ±      6.154  ns/op
Benchmarks.mapObjectOptimizedList             10             5  avgt    4     362.391 ±      2.742  ns/op
Benchmarks.mapObjectOptimizedList             10            10  avgt    4     671.530 ±      9.012  ns/op
Benchmarks.mapObjectOptimizedList            100             1  avgt    4     961.340 ±     99.982  ns/op
Benchmarks.mapObjectOptimizedList            100             2  avgt    4    1661.787 ±     80.087  ns/op
Benchmarks.mapObjectOptimizedList            100             5  avgt    4    3358.468 ±    801.845  ns/op
Benchmarks.mapObjectOptimizedList            100            10  avgt    4    6562.092 ±    154.320  ns/op
Benchmarks.mapObjectOptimizedList           1000             1  avgt    4    9553.851 ±   1544.662  ns/op
Benchmarks.mapObjectOptimizedList           1000             2  avgt    4   14928.944 ±   2299.535  ns/op
Benchmarks.mapObjectOptimizedList           1000             5  avgt    4   31662.521 ±   4165.381  ns/op
Benchmarks.mapObjectOptimizedList           1000            10  avgt    4   62047.941 ±   8370.327  ns/op
Benchmarks.mapObjectOptimizedList          10000             1  avgt    4   96665.009 ±   9231.629  ns/op
Benchmarks.mapObjectOptimizedList          10000             2  avgt    4  151804.315 ±   3441.062  ns/op
Benchmarks.mapObjectOptimizedList          10000             5  avgt    4  311116.577 ±   2480.039  ns/op
Benchmarks.mapObjectOptimizedList          10000            10  avgt    4  589796.615 ±   7195.447  ns/op
Benchmarks.mapObjectPreparedOptimizedList      1             1  avgt    4      12.181 ±      7.905  ns/op
Benchmarks.mapObjectPreparedOptimizedList      1             2  avgt    4      18.042 ±      0.975  ns/op
Benchmarks.mapObjectPreparedOptimizedList      1             5  avgt    4      37.445 ±      5.623  ns/op
Benchmarks.mapObjectPreparedOptimizedList      1            10  avgt    4      68.590 ±      8.244  ns/op
Benchmarks.mapObjectPreparedOptimizedList     10             1  avgt    4      93.989 ±     42.978  ns/op
Benchmarks.mapObjectPreparedOptimizedList     10             2  avgt    4     151.071 ±     75.593  ns/op
Benchmarks.mapObjectPreparedOptimizedList     10             5  avgt    4     323.802 ±    150.050  ns/op
Benchmarks.mapObjectPreparedOptimizedList     10            10  avgt    4     636.621 ±    277.193  ns/op
Benchmarks.mapObjectPreparedOptimizedList    100             1  avgt    4     931.964 ±    448.715  ns/op
Benchmarks.mapObjectPreparedOptimizedList    100             2  avgt    4    1556.934 ±   1498.777  ns/op
Benchmarks.mapObjectPreparedOptimizedList    100             5  avgt    4    3152.102 ±   1555.233  ns/op
Benchmarks.mapObjectPreparedOptimizedList    100            10  avgt    4    5767.812 ±   3729.109  ns/op
Benchmarks.mapObjectPreparedOptimizedList   1000             1  avgt    4    9925.449 ±    767.232  ns/op
Benchmarks.mapObjectPreparedOptimizedList   1000             2  avgt    4   16019.041 ±   1611.765  ns/op
Benchmarks.mapObjectPreparedOptimizedList   1000             5  avgt    4   33229.602 ±   2567.911  ns/op
Benchmarks.mapObjectPreparedOptimizedList   1000            10  avgt    4   61968.263 ±   5416.820  ns/op
Benchmarks.mapObjectPreparedOptimizedList  10000             1  avgt    4   99694.790 ±   5501.550  ns/op
Benchmarks.mapObjectPreparedOptimizedList  10000             2  avgt    4  154344.565 ±  24275.080  ns/op
Benchmarks.mapObjectPreparedOptimizedList  10000             5  avgt    4  323076.593 ±   5932.212  ns/op
Benchmarks.mapObjectPreparedOptimizedList  10000            10  avgt    4  552097.315 ±  31288.459  ns/op
Benchmarks.mapObjectSequence                   1             1  avgt    4      16.882 ±      3.662  ns/op
Benchmarks.mapObjectSequence                   1             2  avgt    4      26.725 ±      7.006  ns/op
Benchmarks.mapObjectSequence                   1             5  avgt    4      69.432 ±      8.218  ns/op
Benchmarks.mapObjectSequence                   1            10  avgt    4     136.093 ±      7.593  ns/op
Benchmarks.mapObjectSequence                  10             1  avgt    4      73.499 ±      0.917  ns/op
Benchmarks.mapObjectSequence                  10             2  avgt    4     110.875 ±      8.592  ns/op
Benchmarks.mapObjectSequence                  10             5  avgt    4     311.204 ±     52.067  ns/op
Benchmarks.mapObjectSequence                  10            10  avgt    4     599.408 ±     14.731  ns/op
Benchmarks.mapObjectSequence                 100             1  avgt    4     665.505 ±    196.541  ns/op
Benchmarks.mapObjectSequence                 100             2  avgt    4     957.423 ±     46.574  ns/op
Benchmarks.mapObjectSequence                 100             5  avgt    4    2692.577 ±    342.740  ns/op
Benchmarks.mapObjectSequence                 100            10  avgt    4    5135.334 ±    510.752  ns/op
Benchmarks.mapObjectSequence                1000             1  avgt    4    6248.692 ±    551.226  ns/op
Benchmarks.mapObjectSequence                1000             2  avgt    4    9429.240 ±    556.904  ns/op
Benchmarks.mapObjectSequence                1000             5  avgt    4   28022.353 ±   8686.226  ns/op
Benchmarks.mapObjectSequence                1000            10  avgt    4   50510.813 ±   1143.028  ns/op
Benchmarks.mapObjectSequence               10000             1  avgt    4   62503.227 ±   5291.316  ns/op
Benchmarks.mapObjectSequence               10000             2  avgt    4   98243.877 ±  15723.730  ns/op
Benchmarks.mapObjectSequence               10000             5  avgt    4  275140.914 ±  98815.505  ns/op
Benchmarks.mapObjectSequence               10000            10  avgt    4  608063.506 ±  19499.621  ns/op
```