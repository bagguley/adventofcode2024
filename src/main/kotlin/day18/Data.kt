package day18

val testData = """
5,4
4,2
4,5
3,0
2,1
6,3
2,4
1,5
0,6
3,3
2,6
5,1
1,2
5,5
2,5
6,5
1,4
0,4
6,4
1,1
6,1
1,0
0,5
1,6
2,0
""".trimIndent().split("\n")

val data = """
40,65
17,1
34,45
31,51
29,43
25,9
14,27
5,29
41,59
46,59
57,43
15,33
67,59
56,67
54,47
53,50
21,23
41,65
31,13
65,47
48,59
68,45
62,67
20,7
28,9
61,67
53,69
29,27
27,6
42,37
29,9
10,7
25,57
59,48
27,11
36,61
39,51
43,67
31,53
19,0
31,15
29,24
13,23
55,39
49,69
20,27
24,5
53,67
54,55
1,7
67,55
23,17
35,64
20,17
20,61
13,1
59,58
17,65
27,0
53,58
11,23
55,47
70,63
65,59
8,15
32,39
35,60
67,51
0,27
22,23
6,25
13,9
26,57
23,23
41,54
25,61
13,24
21,19
67,61
66,65
57,45
33,52
23,58
65,68
37,47
21,9
42,53
6,7
11,7
13,18
7,13
33,39
30,27
19,2
29,25
57,69
55,63
7,8
49,54
21,66
27,26
57,51
15,9
36,49
53,40
11,9
69,69
10,31
66,53
33,53
27,17
21,7
17,13
63,67
16,7
10,9
55,50
25,10
56,61
18,21
58,51
60,53
10,21
20,31
23,13
31,5
37,51
66,45
1,20
63,61
5,6
17,19
52,63
19,18
57,46
21,13
27,58
40,59
32,43
12,5
15,15
29,16
68,69
53,51
24,29
23,64
23,19
19,3
61,37
17,21
15,7
39,63
46,63
48,41
39,54
37,39
27,24
60,65
39,38
39,47
25,3
35,58
20,5
49,55
32,53
31,24
60,67
2,13
27,12
51,58
33,63
57,44
61,60
3,30
1,2
11,21
14,9
11,1
33,58
57,68
21,11
1,5
67,48
63,62
19,10
57,56
12,17
69,66
21,64
23,12
22,9
33,67
15,18
29,42
1,9
49,61
57,47
11,20
18,9
67,47
31,40
14,25
2,19
25,21
68,61
35,51
27,65
43,59
55,36
10,17
29,22
23,2
50,43
61,33
27,31
16,29
10,15
59,37
16,57
29,12
16,15
53,65
17,24
23,6
19,15
16,11
44,69
37,43
33,10
44,51
57,35
58,55
43,45
47,69
35,61
63,59
7,24
29,63
44,53
2,1
43,50
51,30
34,55
9,11
18,23
9,3
39,49
27,61
51,63
60,41
3,8
54,61
45,57
49,50
35,47
38,57
60,55
37,38
36,57
25,23
38,67
17,3
69,47
61,41
15,13
22,1
39,31
55,70
19,17
27,23
17,8
9,13
32,57
41,43
42,1
8,31
41,46
37,9
19,7
2,23
11,17
41,45
41,58
5,1
25,13
18,63
35,37
19,24
33,65
5,9
31,61
13,20
32,21
66,49
28,29
18,29
3,17
15,0
31,47
17,7
38,61
31,1
27,29
59,47
45,54
17,26
39,48
56,49
63,49
21,29
27,57
5,21
12,33
57,65
29,61
9,9
57,66
24,25
52,55
59,55
55,60
25,2
1,1
17,57
11,5
51,45
65,45
25,5
17,23
47,57
41,62
47,53
1,8
16,21
59,61
45,59
58,43
49,37
59,40
63,57
35,65
5,18
5,19
9,20
57,34
63,70
23,57
58,47
7,19
22,27
67,70
51,46
4,17
58,37
67,63
14,5
53,57
9,7
69,58
15,25
14,3
63,58
67,53
38,65
37,49
55,61
59,67
3,29
57,49
55,67
25,60
33,41
14,63
55,43
65,63
27,4
29,47
10,11
41,48
30,11
11,24
25,26
61,55
61,52
27,5
59,51
41,44
53,53
37,35
65,52
39,62
51,68
45,56
12,3
40,63
13,19
57,42
12,1
8,23
33,50
19,6
51,69
18,5
8,27
20,13
11,65
13,11
36,39
2,27
60,69
17,11
53,55
69,49
55,52
27,14
13,27
1,11
32,3
59,62
49,56
10,13
9,5
65,57
3,11
9,4
29,40
23,9
19,57
63,38
65,60
9,1
5,25
23,4
19,1
59,53
15,14
39,50
69,67
33,62
23,11
7,22
53,61
15,1
18,3
5,17
9,27
37,63
24,33
40,43
39,67
57,59
20,9
12,11
18,13
68,55
33,57
51,41
68,51
1,13
45,49
7,25
23,7
2,11
61,39
65,69
32,15
31,57
53,49
34,65
3,7
21,5
3,1
15,16
9,25
41,33
59,65
21,1
17,5
67,67
59,45
44,59
14,13
52,65
25,8
61,63
1,15
51,59
57,67
15,28
39,39
13,15
67,64
69,63
45,55
55,64
65,43
5,7
59,41
31,44
3,25
69,56
11,3
23,35
47,63
55,65
21,30
3,27
53,41
12,27
29,36
7,23
7,4
65,53
8,9
19,11
32,47
43,53
60,63
35,49
24,11
41,56
42,41
27,55
24,15
46,53
33,47
57,40
37,40
30,63
26,3
63,51
37,48
61,69
62,49
67,49
23,3
69,53
32,61
25,55
11,22
51,67
25,25
22,25
35,43
7,9
60,49
3,3
55,53
30,57
37,61
5,14
33,42
69,50
3,5
33,49
33,43
7,27
7,11
65,50
67,57
58,65
7,26
63,65
31,11
53,42
67,69
53,37
1,3
67,60
67,68
6,3
13,10
61,68
15,8
29,41
2,5
29,14
21,14
16,5
35,44
47,66
17,29
35,41
43,47
59,43
4,27
49,38
27,7
19,9
23,29
49,60
19,20
15,5
1,31
60,45
57,53
22,31
5,12
5,5
4,25
5,20
68,47
38,51
43,61
36,63
69,59
27,49
21,12
12,7
37,41
19,5
7,16
8,13
50,69
3,19
9,21
4,21
61,47
65,58
59,63
59,69
39,41
22,15
15,19
57,32
5,11
17,12
6,1
65,48
16,1
66,57
7,7
37,37
64,43
63,69
7,5
27,9
61,57
40,41
27,54
14,19
21,27
19,13
1,10
64,47
13,6
65,66
27,10
25,32
9,31
24,9
15,27
55,51
25,54
2,3
41,49
43,58
1,17
31,8
32,51
35,57
18,33
68,65
33,59
7,15
47,70
64,61
46,43
54,65
50,33
5,0
55,37
5,23
61,49
25,19
54,57
61,46
63,43
4,7
10,25
26,13
57,62
16,25
53,52
65,54
1,27
27,59
41,61
3,16
62,55
5,13
54,69
1,23
51,60
25,35
43,56
23,21
0,15
23,15
23,27
56,47
25,11
11,13
29,57
51,66
43,60
64,67
33,2
52,61
22,21
8,11
53,59
27,46
1,21
15,22
37,55
22,7
4,11
57,61
69,65
1,25
41,53
40,47
13,5
35,52
34,61
32,59
21,16
7,3
31,46
31,39
27,44
61,36
3,13
26,15
51,57
24,17
66,43
54,67
51,65
31,64
17,9
1,24
65,49
11,11
29,15
8,5
35,63
13,21
61,59
11,2
57,58
50,63
54,63
23,1
15,23
15,21
49,59
34,41
28,5
25,59
41,41
21,25
65,55
65,64
17,61
3,15
35,3
69,52
11,25
8,19
59,57
53,54
37,45
42,65
56,57
19,21
56,41
56,53
41,67
63,56
4,23
17,18
45,61
19,29
51,56
62,63
29,23
69,51
37,64
3,9
23,28
14,11
40,53
47,39
46,51
6,17
5,10
33,66
64,55
19,31
26,29
43,62
63,47
65,65
35,46
21,17
38,43
15,11
37,46
54,45
28,67
20,21
62,45
13,25
35,45
33,55
50,35
27,15
10,27
39,57
29,60
12,13
39,61
25,7
3,6
49,62
18,15
32,65
9,23
43,55
28,21
3,22
31,7
19,23
5,3
43,63
45,63
41,16
29,28
59,31
60,57
41,63
36,51
33,61
25,31
57,63
59,50
41,51
59,59
17,25
31,54
27,2
25,30
24,35
59,38
31,55
38,55
13,65
17,20
13,13
41,55
27,13
23,33
59,60
21,24
28,25
69,60
37,59
25,49
31,41
45,53
62,39
48,53
48,67
23,59
31,56
29,62
19,19
43,57
64,41
49,53
49,67
55,45
48,51
58,53
33,48
25,22
65,51
7,14
43,49
35,39
17,17
39,43
34,39
55,55
13,3
31,49
27,8
34,67
59,39
27,64
50,57
3,14
51,53
29,21
55,57
31,59
16,3
7,21
5,27
31,22
63,64
69,54
9,34
3,21
67,56
41,57
56,27
41,47
67,62
59,49
62,47
36,43
51,61
67,65
10,33
49,64
11,27
12,15
43,64
7,1
62,51
39,59
1,16
55,44
34,49
6,19
6,11
8,1
53,34
27,60
15,17
47,56
31,63
41,60
13,22
0,5
47,58
20,29
53,48
47,65
39,65
31,45
49,57
17,27
43,65
10,3
52,69
52,43
25,63
27,1
35,56
25,15
23,31
55,59
31,9
55,49
47,55
37,65
4,3
30,59
61,65
39,45
35,53
9,29
70,47
57,57
26,27
51,48
51,49
11,29
2,31
26,51
21,21
65,67
31,3
23,65
19,25
31,23
62,59
25,29
38,41
35,59
47,42
38,45
3,26
35,67
17,15
59,30
1,19
13,7
25,27
53,63
33,45
11,8
50,51
5,15
61,61
38,59
55,69
57,54
35,54
27,27
3,23
7,29
57,64
28,17
69,57
11,35
58,69
1,18
15,3
69,61
55,41
63,11
55,5
53,6
6,47
63,25
9,70
15,32
42,29
41,2
43,6
3,67
40,19
67,43
49,18
62,31
49,65
21,51
30,7
45,15
9,63
19,53
61,42
38,13
33,13
27,33
42,13
67,21
37,29
45,21
36,15
1,47
29,29
67,35
57,23
15,62
19,50
4,67
36,11
25,42
68,41
33,1
49,44
15,67
51,21
68,19
13,35
24,21
43,11
2,61
69,38
10,39
58,11
9,57
61,31
57,17
31,65
18,61
67,37
16,45
69,29
67,25
22,51
45,31
63,5
27,67
17,37
24,39
54,5
3,52
33,29
1,33
17,66
7,51
13,61
55,27
61,21
5,50
65,1
31,31
53,45
1,48
31,10
60,11
38,31
7,66
39,37
3,57
68,21
13,42
38,5
66,41
65,25
44,13
69,4
55,23
17,70
2,65
63,39
11,36
13,17
51,2
49,41
44,33
7,50
8,37
11,54
1,64
30,19
11,67
19,56
47,25
15,29
41,14
17,39
15,51
39,32
48,11
60,37
59,19
49,17
35,6
63,63
63,34
9,41
55,7
19,65
45,7
63,12
17,41
29,49
65,61
33,23
63,52
3,59
45,68
39,5
37,36
5,45
48,7
3,39
29,33
31,67
39,27
46,23
69,23
29,69
69,43
33,12
37,5
11,56
7,41
5,70
19,47
45,37
14,39
45,13
57,37
6,39
66,31
41,30
58,5
47,15
43,25
47,36
37,7
27,37
65,41
45,45
31,4
33,24
47,1
49,11
63,20
3,51
35,19
37,2
62,27
35,34
1,51
35,4
45,25
29,45
15,63
55,1
25,17
68,23
69,39
42,17
49,45
39,34
41,12
9,69
25,38
1,65
49,25
36,69
52,11
32,17
69,3
69,35
15,38
7,52
51,37
33,37
59,17
39,10
31,0
13,52
43,23
15,65
49,3
10,53
61,4
17,49
24,69
15,69
7,62
51,29
24,47
15,57
0,67
22,35
69,33
41,11
63,18
19,69
23,45
13,54
38,9
63,1
63,9
47,67
47,7
46,3
27,63
3,47
67,39
43,69
65,24
67,15
39,25
65,3
38,25
39,69
60,15
29,34
23,25
38,17
51,39
7,49
28,51
53,35
19,33
56,11
3,45
63,45
68,39
66,1
41,70
67,23
5,64
29,2
63,4
65,17
21,40
27,43
59,5
1,63
61,19
45,17
69,26
10,51
41,32
31,14
20,67
65,32
17,59
28,45
31,25
29,39
45,1
19,68
45,39
21,15
5,44
36,67
12,49
3,68
1,52
63,23
45,20
23,43
1,69
21,3
69,5
41,4
49,35
3,35
0,41
11,53
42,9
51,31
57,19
19,51
33,69
43,68
49,23
5,68
45,35
42,31
9,47
39,19
57,27
47,43
48,15
63,22
49,63
15,41
41,28
69,30
2,43
21,2
14,55
5,63
36,9
61,1
19,52
11,46
57,29
47,32
5,37
25,45
47,47
44,31
63,3
23,68
45,43
64,9
5,58
49,19
47,51
6,57
33,15
40,3
65,19
25,52
46,31
47,6
2,35
65,13
41,15
47,37
9,33
25,51
55,29
17,45
47,5
43,17
6,33
2,41
35,5
37,52
47,27
7,68
51,13
23,55
45,28
33,38
44,41
67,1
3,43
3,61
54,1
47,34
5,32
35,9
57,28
67,5
13,49
55,15
67,6
43,31
51,52
13,36
66,7
9,62
3,38
55,9
41,29
0,29
46,19
39,36
62,9
42,39
43,3
29,55
65,7
65,18
29,66
17,69
32,29
41,1
29,50
45,19
37,13
51,17
64,45
18,41
47,45
67,14
44,47
43,22
36,33
22,19
42,7
35,17
1,37
20,39
14,29
59,11
31,70
57,3
67,24
19,41
12,47
41,37
9,35
7,28
35,21
45,67
51,11
49,4
67,45
51,51
51,4
11,40
12,57
50,21
30,37
49,13
15,35
9,51
57,18
29,11
51,23
47,11
69,27
26,41
46,39
11,69
31,43
39,8
63,27
53,23
35,32
35,35
23,41
45,41
61,6
17,33
5,49
7,44
11,19
2,45
21,49
22,53
40,27
66,27
43,66
25,37
1,55
23,47
67,29
61,18
1,41
43,1
17,63
53,33
39,35
51,7
5,60
29,52
63,31
37,28
5,69
31,68
65,38
39,9
50,11
58,29
3,46
18,45
33,7
50,5
40,39
35,25
39,33
49,8
5,55
9,60
70,11
67,18
53,5
9,19
68,5
19,37
67,10
46,7
45,51
45,8
69,7
15,50
23,51
39,13
37,67
35,2
16,49
2,39
23,37
25,20
21,35
21,56
67,36
21,42
3,69
15,34
15,52
3,42
66,3
33,18
15,59
29,68
23,69
13,39
39,23
57,16
63,35
57,55
69,36
67,16
9,56
22,33
15,44
21,62
59,18
43,13
1,59
62,25
41,36
16,69
11,62
43,7
56,21
47,29
53,24
11,47
63,2
26,63
50,39
15,58
25,67
31,36
19,45
52,17
55,16
13,29
3,63
51,3
13,47
30,49
13,44
9,61
37,30
28,41
63,13
39,55
7,39
68,27
6,37
33,9
34,15
67,9
67,7
59,22
20,33
63,21
33,31
35,13
58,13
3,56
65,9
14,67
44,23
15,53
2,59
63,53
36,7
39,21
52,45
9,44
33,27
53,1
39,12
63,36
49,15
69,14
54,41
21,43
35,14
49,7
19,34
33,5
45,9
47,13
47,31
43,15
27,36
55,38
29,3
61,17
69,9
46,45
15,45
59,33
37,21
27,51
66,33
43,33
12,51
5,47
41,26
57,39
7,31
53,15
64,35
57,7
19,67
56,1
65,33
59,15
54,25
1,35
41,7
58,25
59,35
57,4
45,34
7,42
56,33
7,43
37,53
22,67
4,39
67,27
11,37
45,26
48,9
14,41
18,47
21,54
18,55
61,20
23,67
14,59
41,0
17,53
7,35
11,61
34,1
17,60
37,1
45,65
34,7
39,29
27,34
43,37
52,27
57,41
37,19
52,49
53,9
17,36
15,46
19,42
56,9
57,31
40,17
3,33
5,52
41,23
38,1
21,69
9,45
21,38
69,1
45,66
5,57
51,35
13,37
52,33
21,55
27,32
48,21
69,37
4,63
53,18
13,67
51,19
6,65
7,57
35,36
29,48
49,9
30,3
53,31
7,67
22,57
16,41
59,0
63,8
0,47
45,33
43,43
62,33
24,55
37,57
9,65
41,19
63,17
27,47
37,4
49,33
53,8
21,63
65,21
61,53
15,36
17,55
10,67
1,57
45,29
49,34
55,21
59,3
35,69
14,65
29,19
33,3
4,55
34,17
23,60
25,50
11,45
47,60
55,31
59,21
8,49
8,67
13,34
13,43
54,13
58,35
3,54
52,37
41,25
49,28
11,31
42,23
26,45
44,11
55,2
66,15
21,67
56,7
13,32
43,35
47,59
23,63
5,54
70,43
11,39
46,1
69,45
27,48
51,36
51,27
5,53
59,29
18,51
21,37
13,31
12,43
1,39
37,16
17,48
69,21
50,9
43,21
21,61
61,24
61,23
7,55
9,50
69,31
52,3
20,49
49,21
19,39
55,11
31,27
49,31
27,3
51,33
61,9
50,17
55,26
64,31
51,28
35,18
40,23
51,26
33,30
35,33
3,37
12,63
1,54
28,63
47,64
7,53
35,29
45,16
5,33
65,29
53,19
52,9
43,34
69,40
51,55
31,29
43,27
69,12
47,9
33,21
13,63
49,1
52,13
17,43
21,31
21,45
53,21
70,7
61,51
61,12
7,61
44,39
27,45
49,43
53,13
60,33
26,69
14,49
68,3
11,43
7,46
61,45
61,43
47,49
13,57
63,7
63,15
15,61
49,39
54,37
53,20
12,39
39,15
53,39
61,14
3,41
39,1
45,30
57,22
46,41
28,19
39,26
1,29
50,13
30,43
43,10
29,53
39,68
49,47
27,19
41,69
47,33
57,10
65,27
9,43
31,35
31,20
40,21
65,31
24,61
51,1
63,40
17,42
59,25
67,22
43,39
30,31
29,59
9,64
21,65
15,56
47,46
59,8
2,69
38,21
39,30
16,31
69,25
39,3
65,35
15,49
31,12
51,47
5,41
41,35
45,11
5,65
69,41
41,17
9,48
37,33
53,27
53,25
36,29
5,31
69,19
43,24
9,59
49,51
1,45
64,29
41,21
44,43
9,55
44,49
1,61
44,27
67,31
0,33
47,41
57,11
14,47
5,34
65,26
36,35
62,1
69,28
26,17
25,41
7,45
19,44
43,41
9,53
49,2
49,5
55,3
48,37
11,64
40,9
59,23
25,47
4,45
23,49
14,69
43,51
27,56
45,38
32,5
56,19
21,47
29,31
18,65
61,44
43,29
24,65
65,37
43,44
2,33
47,20
23,52
65,5
57,2
49,27
33,17
33,11
47,68
39,14
25,69
64,3
35,20
27,38
33,33
45,69
15,43
45,5
46,13
55,13
61,7
6,61
17,47
65,11
37,15
51,43
34,9
3,53
35,7
49,22
47,4
33,35
53,17
26,47
16,53
23,39
29,13
63,19
17,58
26,35
63,16
9,49
15,39
27,69
45,27
65,14
68,9
11,66
17,35
37,18
23,5
57,21
22,49
57,33
69,2
20,57
27,41
29,37
67,11
21,70
61,13
1,49
29,1
3,55
11,63
11,38
53,7
29,35
11,58
45,18
44,9
11,51
41,31
5,48
56,37
69,17
21,60
15,55
32,7
55,25
19,26
51,20
57,13
54,11
23,36
23,42
49,49
55,28
3,48
19,55
21,59
1,53
58,7
12,61
21,39
68,43
7,58
55,33
29,67
66,35
37,3
31,21
3,49
4,61
31,69
15,47
59,7
45,47
53,22
57,15
57,5
35,15
61,3
60,23
15,37
63,33
34,31
7,63
25,1
39,17
23,53
53,11
11,57
51,16
61,27
5,59
59,34
50,47
69,15
37,27
19,63
63,41
53,29
63,37
3,50
55,4
33,25
64,11
9,42
17,32
47,17
20,37
37,31
69,13
11,49
4,35
11,59
46,49
36,23
54,29
16,39
13,55
65,0
41,13
44,3
9,39
41,39
51,22
48,17
33,19
52,15
41,3
21,57
48,45
67,41
12,29
16,61
29,17
31,33
32,33
44,1
61,15
39,6
13,69
35,22
69,34
61,29
41,34
60,3
69,11
25,43
15,31
35,23
59,13
31,32
66,37
43,5
13,59
46,27
1,56
23,44
3,66
60,27
51,15
19,59
9,15
3,58
51,24
19,58
5,39
57,1
39,7
35,55
61,16
32,27
11,33
59,26
19,61
26,67
13,30
5,51
49,26
49,14
5,42
65,15
13,33
11,55
0,61
59,9
31,17
47,19
22,47
45,62
23,62
47,3
18,39
67,30
61,30
7,54
67,33
53,3
7,56
7,37
49,29
19,43
26,21
34,25
61,25
63,55
63,28
34,21
35,1
65,6
17,68
48,1
67,28
47,35
9,58
39,53
37,42
51,25
11,41
48,25
22,37
35,70
59,20
13,41
46,15
53,32
17,54
67,13
9,46
35,28
5,36
50,41
11,68
21,46
8,63
25,66
59,6
50,31
54,31
63,29
34,35
1,50
41,68
45,23
57,9
19,27
37,25
29,5
65,20
5,43
10,43
61,11
37,69
4,31
25,53
27,25
19,49
21,53
21,44
1,43
37,17
54,23
45,3
55,20
36,25
60,29
43,19
39,11
67,19
7,33
69,55
64,13
5,35
1,36
7,59
47,24
17,51
35,12
47,61
17,31
46,11
29,54
12,67
4,29
69,32
41,50
45,36
41,20
51,6
57,25
8,35
9,17
63,6
17,67
48,31
5,67
24,49
47,23
25,56
9,37
13,45
59,1
7,65
65,39
70,21
67,3
37,23
1,67
56,13
29,38
41,27
5,40
32,35
47,48
61,5
53,47
23,18
29,7
39,24
43,46
57,14
31,19
19,35
20,47
55,17
51,5
43,20
53,30
3,31
27,18
31,26
64,17
21,41
60,9
44,5
11,60
37,11
69,16
67,8
23,61
41,9
25,33
23,40
41,5
48,29
3,65
31,37
64,25
10,29
7,17
59,27
5,61
27,35
33,68
27,53
33,51
44,15
48,13
54,15
21,33
53,43
51,9
7,47
25,39
27,21
9,67
47,21
61,35
24,43
34,27
7,30
67,12
59,16
9,36
7,69
55,19
29,65
27,39
25,65
41,6
29,51
35,27
13,53
8,39
57,24
55,35
13,51
27,62
28,31
43,9
37,22
35,31
65,23
59,2
11,15
16,65
66,21
19,64
35,11
52,39
67,17
18,35
14,26
32,48
16,54
16,66
22,62
62,14
24,45
18,60
50,25
28,35
40,44
39,22
18,59
19,54
32,34
66,36
31,50
36,68
10,61
18,52
18,56
24,38
4,22
30,32
48,24
24,36
58,6
11,18
50,60
25,70
4,62
3,40
16,68
27,30
4,24
52,34
46,6
15,10
56,66
41,42
70,0
68,22
9,26
67,34
46,2
9,8
34,37
18,57
14,30
5,24
38,23
52,40
35,38
14,58
66,22
68,7
12,55
42,59
70,17
26,32
49,10
66,60
6,23
34,32
6,0
43,18
38,36
70,20
64,36
23,46
64,23
7,64
42,40
22,22
46,70
0,39
66,4
62,6
8,28
61,34
50,7
48,23
46,48
34,18
44,55
1,30
63,46
56,8
14,31
66,40
22,24
20,53
25,62
28,43
64,15
20,30
3,0
61,0
30,14
50,26
63,14
38,46
45,58
65,4
42,67
62,5
26,10
6,66
3,36
11,34
11,6
40,40
40,60
18,32
60,10
40,46
43,70
10,70
42,52
40,24
57,36
8,50
39,18
24,40
52,44
42,24
34,59
3,28
60,21
1,14
34,60
29,58
16,42
62,23
52,51
28,66
22,54
56,3
28,49
13,48
56,44
44,66
46,26
59,4
35,48
22,66
49,42
28,56
5,62
44,26
66,5
34,48
52,0
22,29
8,18
48,4
8,70
17,38
20,63
70,4
16,43
17,30
40,64
8,65
42,30
17,44
40,69
18,1
13,62
12,68
65,2
26,62
18,10
32,18
36,16
50,44
44,54
70,44
44,46
18,34
9,18
59,64
20,43
46,66
4,0
30,47
69,8
24,70
20,52
8,30
58,31
41,64
26,43
46,57
40,55
68,16
25,14
10,66
14,2
24,12
29,56
51,54
38,30
12,44
31,38
68,4
35,62
40,26
22,6
38,19
1,0
3,32
24,13
40,28
24,59
42,50
26,26
45,42
0,53
2,63
43,4
12,70
54,62
28,65
64,44
62,17
31,62
51,62
44,16
56,62
24,67
0,30
60,39
63,24
52,1
60,0
49,46
34,68
50,68
66,11
20,10
8,53
68,35
4,19
34,36
64,52
50,59
2,32
53,68
22,11
18,49
54,24
15,64
43,28
66,70
34,43
6,41
8,55
44,61
16,30
33,56
26,9
23,38
31,52
42,26
0,37
35,16
68,60
26,58
70,38
45,48
54,16
36,60
25,40
8,52
26,39
46,20
61,8
2,38
8,69
41,24
51,8
21,4
33,32
32,46
30,17
56,31
10,16
32,50
19,30
70,8
46,24
58,30
45,22
4,2
42,14
28,24
44,22
4,58
40,36
67,66
38,39
60,66
20,70
47,62
0,34
6,43
48,47
48,2
10,23
61,22
34,22
32,25
32,55
1,28
48,55
30,55
15,66
38,32
2,42
16,64
50,24
12,14
36,62
36,66
22,69
12,48
43,16
20,28
69,42
50,70
22,63
31,30
66,64
55,42
62,19
14,46
42,20
47,54
21,34
45,44
6,68
41,22
18,54
30,46
40,48
36,17
38,2
56,10
36,26
51,70
44,6
46,40
18,53
46,30
18,0
48,44
0,31
3,44
70,6
0,13
66,48
26,44
40,35
37,34
50,40
20,41
18,43
27,50
11,26
51,34
46,5
0,58
48,26
10,64
14,14
7,34
8,22
11,16
47,40
6,69
44,56
43,52
46,67
70,29
52,52
30,65
18,67
16,10
28,18
8,59
5,2
45,10
60,30
18,27
65,46
68,67
48,0
12,34
3,18
18,19
23,50
0,28
4,37
21,52
70,41
26,22
25,68
4,41
40,45
46,38
64,46
4,68
36,24
60,32
26,30
26,59
58,34
62,66
45,4
13,70
12,35
64,62
48,39
9,16
56,5
66,16
64,22
8,41
14,37
42,64
70,35
68,37
52,54
2,21
47,50
39,28
32,38
46,22
4,44
68,12
48,50
19,28
57,20
66,44
15,2
26,34
62,52
66,46
16,59
20,36
38,20
21,68
18,50
24,58
43,30
34,19
58,10
3,20
2,52
13,16
50,30
15,60
42,70
26,55
40,30
37,62
14,70
18,2
44,21
34,47
18,36
44,8
68,44
48,54
2,26
10,57
25,44
69,44
16,28
49,6
22,50
36,70
19,66
64,32
42,28
13,46
41,38
32,52
0,22
68,70
12,31
26,0
32,42
36,45
25,58
44,24
14,64
2,44
1,22
47,14
36,58
42,5
14,28
42,45
36,37
44,14
22,5
45,52
16,26
32,49
67,46
62,4
17,34
29,70
14,42
12,60
14,54
25,34
68,24
64,7
63,68
2,29
25,12
51,44
0,14
64,14
40,34
50,65
62,32
34,30
58,64
17,50
46,58
19,38
32,58
45,0
30,62
34,58
0,70
40,49
62,36
26,38
46,35
50,46
38,24
18,64
14,36
16,67
30,56
46,47
9,66
64,4
6,48
30,70
36,32
14,68
10,47
22,30
66,24
0,35
10,46
52,50
39,58
48,28
10,40
8,42
12,19
22,65
38,70
44,18
67,44
0,50
59,10
22,70
24,56
13,58
14,40
10,42
39,40
14,53
39,70
58,4
48,56
24,23
46,18
66,32
8,66
15,6
1,26
36,55
62,26
22,34
35,10
2,60
64,26
35,42
45,40
63,60
16,13
25,24
20,60
52,18
0,51
25,6
4,5
50,23
59,28
40,16
2,15
48,58
60,48
64,60
42,19
48,20
12,0
17,28
45,64
38,7
42,33
70,52
16,33
53,38
40,14
60,34
47,22
44,60
59,42
23,26
40,6
28,2
4,65
16,47
67,20
2,37
18,24
33,70
2,28
2,51
65,56
36,41
62,34
70,24
10,5
38,47
56,14
28,54
52,14
8,57
38,28
2,58
60,4
58,66
30,6
70,36
38,38
42,68
31,2
25,16
42,25
20,3
58,38
66,29
64,54
62,69
24,63
63,0
65,10
39,42
35,40
24,64
0,48
36,20
14,4
6,34
21,20
37,10
53,44
36,12
54,38
38,16
54,68
34,26
68,33
11,48
40,50
58,2
63,44
20,0
54,19
2,68
8,20
45,50
18,7
1,32
6,49
44,70
14,0
32,70
60,1
6,38
10,68
68,26
52,19
39,20
37,56
50,50
64,49
2,7
62,44
34,5
27,42
64,27
34,0
32,56
60,68
61,58
44,68
30,29
69,70
20,68
60,43
30,21
59,12
40,11
9,38
2,49
52,36
54,7
54,32
27,22
60,38
46,9
51,42
16,62
8,25
30,13
34,12
1,6
6,32
14,22
20,32
2,36
12,37
61,50
53,26
14,61
20,8
48,49
22,32
50,38
68,68
36,56
40,62
9,32
34,63
47,26
54,44
34,62
46,28
40,51
59,54
49,68
12,58
46,37
23,20
14,32
17,4
53,0
38,11
6,54
67,58
32,23
17,40
52,47
33,60
29,0
28,39
10,52
62,50
13,4
4,56
10,55
37,14
0,18
49,58
52,46
55,18
28,42
43,36
34,54
1,12
48,62
29,20
14,50
30,15
15,40
6,42
68,50
42,62
70,26
28,14
6,59
1,38
43,26
37,24
20,15
24,0
2,54
29,8
49,48
45,6
46,29
26,23
32,2
50,37
8,17
3,62
21,32
21,48
68,56
55,30
42,11
16,22
70,69
44,0
6,9
66,18
41,8
34,14
28,50
29,6
8,14
60,51
22,68
36,18
26,4
26,64
20,54
56,69
37,26
10,14
26,24
23,22
3,2
63,26
61,2
69,64
70,34
32,54
64,38
68,8
44,50
61,38
32,32
38,27
9,6
52,10
56,43
54,6
24,27
70,61
18,25
51,38
58,28
10,26
65,12
58,58
42,36
70,51
40,54
6,55
28,32
28,70
28,30
70,54
63,66
33,36
30,26
30,9
16,40
56,42
6,31
12,50
34,6
2,25
28,55
70,18
28,69
30,22
28,53
36,22
58,19
70,45
55,58
66,8
69,20
56,4
32,31
62,56
50,48
59,70
28,34
30,41
0,32
58,32
68,54
48,22
29,18
0,8
49,16
15,54
22,44
42,38
24,26
57,12
18,62
52,64
32,41
51,32
62,38
48,66
15,30
34,13
53,10
1,58
2,6
58,63
9,40
59,14
6,58
47,30
38,4
58,17
0,40
36,42
12,20
42,27
24,14
40,33
26,40
20,66
22,8
68,38
26,31
5,46
54,70
0,60
26,2
4,64
36,14
33,26
3,64
6,50
20,59
44,10
55,32
65,34
70,23
66,13
39,0
34,10
7,32
12,56
32,20
50,4
68,42
12,22
4,1
47,28
42,63
38,68
37,6
28,15
2,4
24,7
4,18
14,15
58,54
26,66
50,36
60,61
54,9
60,47
50,56
28,36
1,60
47,2
64,6
46,25
64,50
8,21
64,28
66,28
63,50
40,0
28,11
8,45
2,47
54,39
""".trimIndent().split("\n")