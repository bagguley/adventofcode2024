package day12

val testData = """
RRRRIICCFF
RRRRIICCCF
VVRRRCCFFF
VVRCCCJFFF
VVVVCJJCFE
VVIVCCJJEE
VVIIICJJEE
MIIIIIJJEE
MIIISIJEEE
MMMISSJEEE
""".trimIndent().split("\n")

val testData2 = """
AAAA
BBCD
BBCC
EEEC
""".trimIndent().split("\n")

val testData3 = """
OOOOO
OXOXO
OOOOO
OXOXO
OOOOO
""".trimIndent().split("\n")

val testData4 = """
EEEEE
EXXXX
EEEEE
EXXXX
EEEEE
""".trimIndent().split("\n")

val testData5 = """
AAAAAA
AAABBA
AAABBA
ABBAAA
ABBAAA
AAAAAA
""".trimIndent().split("\n")

val data = """
DDDDDDDDDDDDDDDDDHHHHHHDDDDBBBBBBBBBBBBBBBBBBBBBBBBBAKAAQQRRRGGGGGGGGZZGAQRQRQQQQQQQCCCCCCCCCCCCCCCZZEZJZZZZZZZZZZZZZZUUUUUUUUUUUUUIIIIIIIII
DDDDDDDDDDDDDDDDDHHHHDDDDDDBBBBBBBBBBBBBBBBBBBBBBBBAAAAAQQRRRRRRGGGGGGGGAQRQQQQQQQQQQQCCCCCCCCCCCCCCZZZZZZZZZZZZZZZZZZZZUUUUUUUUUUUUIIIIIIII
DDDDDDDDDDDDDDDHDDHHDDDDDDDBBBBBBBBBBBBBBBBBBBBBBBBAAXAAQARRRRRRGGGGGGKKAQQQQQQQQQQQQQQQCCCCYCCCYCCCZZZZZZZZZZZVVZZZZZZZVUUUUUUUUUUUIIIIIIII
DDDDDDDDDDDDDDDHHHHDDDDDDDDDDDBBBBBBBBBBBBBBBBBBAAAAAAAAAARRRRRRRGGKGGKKQQQQQQQQQQQQQCQQCCCCYYCCYYYCZZZZZZZZZZZVVVZZVZVVVUUUUUUUUUUUUIIIIIII
DDDDDDDDDDDDDDJDDDDDDDDDDDDDDDBBBBBBBBBBBBBBBBBBAAAAAAAAAAAORRRRGGGKKGKKQQQQQQQQQQQQQCCCCCCCYYCYYYYYYZZZZZZZVVVVVUVVVVVVUUUUUUUUUUUUIIIIIIII
DDBBDDDDDDDDDDJJDDDDDDDDDDDDDDBBBBBHBBBBBBBBBBBBBAAAAAAAAAARRRRRRGGKKKKKKQQQQQQQQQQRRRRCCCCCCYCYYYYYYZZZZZZZVVVVVVVVVVVVUUWUUUUUUUUUIIIIIIII
DDDBBDDDBDDDDDJDDDDDDDDDDDDDPBBBBBBBRRBBBBBBBBBBAAAAAAAAAAARRRRRRGEEKKKKKQPQQQQQQQQFRRRRRCCCCYYYYYYYYZZZZZZZZVVVVVVVVVVVVUUVVVUUUUUUIIIIJIII
DDDBBBBBBBDDDJJDDDDDDDDDDDDDPPPBBBBBBBBBGGGBBBBBBBAAAAAAAAAARRXXKKKKKKKKKQPPQPPQQQQQRRRRRRCCCYYYYYYYYZVYYZHZPPVVVVVVVVVVVVVVVVVVLUUUIIJJJJJI
DDBBBBBBBIDDDDDDDDDDDDDDDDDPPPPBBBBBDDLLGLLBBBBBBBBBAAAAAAAAARKKKKKKKKKKKQPPPPPQRRRRRRRRRRRCCCYYYYYYYYYYYZHZYVVVVVVVVVFVVVVVVLLVLQQQQIQQQJII
DDBBBBBBIIDCDHDDDDDDDDDDDDDPPPPPPBBBDLSLLLLLBBBBBBBBBLAALLBBBBBBKBKKKKKKKQPPPPPPPRRRRRRRRRRRCCCEYYYYYYYYYYYYYVVVVVVFFFFFVVVVVVLLLQQQQQQQQJII
MDBBBBBBBBCCDCDPPDDDDDDDDDPPPPPPUBBBDLLLLLLLLLBBBBBBBLALLLBBBBBBBBKKKKKKKKKKKPPPRRRRRRRRRRRREEEEEYYYYYYYYYYYYYYVVVVFFFFFVVVLVVLLLQLQQQQQIIIQ
MMBMMBBBCBCCCCCPPPDDDDDDDDPPPPPPUBBBBLLLLLLLLLBBBBBBVVVVVVBBBBSSBBKKKKKKKKKPZZZZZRRRRRRRRRRRDEEEEYYYYYYYYYYYYYYYVFFFFFFFVLLLLLLLLLLQQQQQQQQQ
MMMMMBBBCCCCCCCPPPDDDDDDNDPPPPPUUUUULLLLLLLLLLBBSBBBVVVVVVVBSSSSSKKKKKKPPPPPZZZZZRRRRRRRRRRDDDEEEYYYYYYYYYYYYYYYFFFFFFFFFWLLLLLLLLLJJJJQQQQQ
MMMMCCCCCCCCCCCCCCWDDDDDDUUPPPPUUUUUULLLLFFLLBBBSSSSVVVVVVVVVVVVVVVOOKKPPPPPZZZZZZRRRRRRRRRDDDEEYYEYYYYYAFYYYYYFFFFFFFFWWWWLLLLLLLLJJJJJQQQQ
MMMMMCCCCCCCCCCCCCCHHHHDDUUUUUUUUUUUUUFLFFFSLSSSSSSSVVVVVVVVVVVVVVVOOEEPPMPPZZZZZZRRRRRRRDDDDDDEEEEEYYYYAAAYYFFFFFFFFFWWWWLLLLLLLLLMJQQQQQQQ
MMMMMCCCCCCCCCCCCCCHHHHHUUUUUUUUUUUUFFFFFFFSLPSSSSSSVVVVVVVVVVVVVVVOOEEPMMPPZZZZZZRRRRRRRDDDDDEEEEEEEYYYAAAFFFFFFFFFFFWWWWLLLLLLLLLLQQQQQQQQ
MMMMCCCCCCCCCCCCUUUHHHHUUUUUUUUUUUQQFFFQFFFSSSSSSSSSVVVVVVVVVVVVVVVOEEEPMMMMZZZZZZRRRRKKKMMDDGGGEEEEQAAAAAAFFFFFFFFFFFFWLLLLLLLLLLLLQQQQQQQQ
MMMMMCCCCCCCCCCCUUUUHHHHHHHHHHHHUUQQQQQQFFSSSSSSSSSSVVVVVVVVVVVVVVVEEEEEDDDMZZZZZZRRRRKKKMMMMGGGGGGEAAAAAJJJJJJJJJJFFFFLLLLLLLLLLLLQQQQQQQNN
MMTMMMMCCCZZCUAUUUUUHHHHHHHHHHHHUUQQQQQQQFSSSSSSSSSSVVVVVVVVVVVVVVVNDDEEDDDDZZZZZZRRBRRKKKMMMMMGGGEEPAAAAJJJJJJJJJJFFAFFLLLLLLLLLLLLQQQQQQQN
MMTMTTMCCCZZZUAAUUUUHZHHHHHHHHHHUUUQQQQQQFFSSSSSSSSSVVVVVVVVVVVVVVVNNDDDVDDDZZZZZBRRBRRKMKMMMMMGGGGEPAAAAJJJJJJJJJJFFAAALLLLLLLLLLLLQNQQQQNN
MMTTTTTTCZZZUUUUUUUUUZZHHHHHHHHHUUUQQQQQFFFSSSSSSSSSVVVVVVVVVVVVVVVSSDDDDDDDZZZDDBBBBBBMMKKMMMMMMMGMAAAAAJJJJJJJJJJFFAAAALLLLLLLLLLQQNNNQNNN
TTTTTTTTZZZUUUUUUUUUEEZHHHHHHHHHHFUQQQFFFFFFSFSSSSSSVVVVNNNNNNNNNNNNNADDDDDDZZZDDBBBBBBMMMKMMMMMMMMMAAAAAJJJJJJJJJJAAAAAALLWWJLWLLLLQNNNNNNN
TTTTTTTZZZZZZZUUUUUUEUAHHHHHHHHHHHHHHHHFFFFFFSSSSSSSVVVVNNNNNNNNNNNNNADDDDDDZZZDDDDBBMMMMMMMMMMMMMMMAACFAJJJJJJJJJJAAAAAAACCCCCCWLLLQNNNNNNN
TTTTTTTZZZZZZZUUUUUUUUUHHHHHHHHHHHHHHHHFFFFFSSSSSSSSVVVVNNNNNNNNNNNNNAAADDDDZZZIIDBBBBMHMMMMMMMMMMMMFFFFFJJJJJJJJJJAAAAAAACCCCCCLLLWWNNNNNNN
TTTTTTTZZZZZZZZZUUUUUUUHHHHHHHHHHHHHHHHHFFSSSSSSSSSSSSSSSNNNNNNNNNNNAAJDDDDDZZZIIDDBBHHHHMMMMMMMMMMMFUFFFJJJJJJJJJJAAAAAAACCCCCCWWWWWNNNNNNN
TTTTJJOJZZZZZZZZZUUUUEUZZZZZZHHHHHHHHHHHFFFFFSSSSXXXXSNNNNNNNNNNNNNNNNJJDDDDZZZIIIIIBBHHMMMRMMMFFMFFJJJJJJJJJJJJJJJAAAAAAACCCCCCWNNWNNNNNNNN
TTCJJJJJJJWZZZZZZZUUUZZZHHHHHHHHHHHHHHHHFFFFFSSSSXXXXNNNNNNNNNNNNNNNNNJDDDDDZZZIIIIIHHHHMMMMMMMMFFJJJJJJJJJJJJJJJJJAAAAAACCCCCCCWNNNNNNNNNNN
CCCJWWJJJJWZZZZZZZZZZZZZHHHHHHHHHHHHHHHHFFFFFFXSXXXXXXNNHHNNNNNNNNNJJJJJDDDDDDDDIIIIHHHHMMMMMMMMFJJJJJJJJJJJJJFAAAACCAAAACCCCCCCWWWNNNNNNNNN
CCCWWWWJWWWWZZZZZZZZZZZOHHHHHHHHHHHHHHHHFFFFFFXXXXXXXXNHHHNNWNNNNNNJJJJJJDDDDDDIIIIHHHHHHHHMMMMMFJJJJJJJJJJJJJJJAAACCCCACCCCCCCCWDWNNWNNNNNN
WWWWWWWJWWWWZZZZZZZZZZZZZZYYYYYZHHHHHHHHYYWWWWWWWWXXXXNHHHNWWWWWNNNNJJJJJDDDDDDDIIIHHHHHHHHHHHMMMJJJJJJJJJJJJJJJACCCCCCCCCCCCCCCWWWWMWNNNNNN
OWWWWWWWWWWWWWZZZZZZZZZZWWYYYYYYYYHHHHHHYFWWWWWWWWXXXXXNHHHWWWWJRNRJJJJJDDJJJJIIIIHHHHHHHHHHMMMMMFJJJJJJJJJJJJJJCCCCCCCCCCCCCCCCWWWWWWWNNNNN
OOWWWWWWWWWWWWZZZZZZZZZZYYYYYYYYYYHHHHHHYYWWWWWWWWFXXXRVHHHWWRRRRRRJJJJJJJJJJJJJIIHHHHHHHHHHMMBBMFFFXXJJJJJJJJJJCCCCCCCCCCCCCCCCWWWWWWWNNNNN
OOOOWWWWWWWWWWZZZZZZZZZZYXYYYYYYYYHHHHHHYYWWWWWWWWFXXXVVVHIIWRRRRRJJJJJJJJJJJJJJIIIMHHHHHHHBBBCBMMMFXXJJJJJJJJJJCCCCCCCCCCCCCCWWWWWWWWWNNNNN
OOWWWWWWWWWWWWWZZZZZZZZZZZZYYYYYYYHHHHHHEEWWWWWWWWFFFVVVHHHIRRRRRRRJJJJJJJJJJJJJZIIHHHHHQHHBBBBBMMBBFFJJJJJJJJJJCCCCCCCCCCCCCCCCCWWWWWNNNNNN
OOWWWWWWWWWWWWZZZZZZWWWWWWZYYYYYYYYEEEESSYWWWWWWWWFVVVVVVHHRRRRRRJJJJJJJJJJJJJZZZZTAAAHAABBBBBBBBBBBBKJJJJJJJJJJCCCCCCCCCCCCCCCCCWWWWWWWNNNN
WWWWWWWWWWWWWWWTTZZZWWWWWWVYVYYYYSYYYYYSSSWWWWWWWWYIVNNNVRRRRRRRRJJJJJJJJJJJJZZZZTTAAAAAABBBBBBBBBBBKKJJJJJJJJJCCCCCCCCCCCCCCCCCCWWWVSSNNNNN
WWRRRWWLVWWLWSTTWWWWWWWWWWVVVYYYSSSSSYSSSSWWWWWWWWYIINNNHRRRRRRRRRJJJJJJJJJJJZZZZAAAAAAAAABBBBBBTTBBYYJJJJJJJJJCCCCCCCCCCCCCCCCCCWWWSSSSNNNN
RWRRRRRLVVWLLTTTWWWWWWWWWVVVVYYSSSSSSSSSSSWWWWWWWWYNNNNNRRRRRRRRRRRLJJJJJJJJZZZZAAAAAAAAAAAABBBBBLYYYYYKKKKKKKKCTTTTTCCCCCCCCCCCCWWWSSSSNSNN
RRRRRRRLLLLLTTTTWWWWWWWWWVVVVVSSSSSSSSSSSWWWWWWWWWYINNNNNRRRYRRRRRRLLJJEEJJJJZZZAAAAAAAAAAAAABBMLLYLLYYKKKKKTKKTTTTTTTCGCCCCCCCCCWWWSSSSSSNN
RRRRRRLLLLTTTTTTWWWWWWXWWVVVVSSSSSSSSSSSSWWWWWWWWYYYYNNNNNRNSSURRRLLLLJEEGJJJZZZZZZAAAAAAAAAABBMLLLLYYYYKKZKTTKTTTTGGGGGGCCCCCCCCWTTSSSSNNNN
RRRRRRLLLLLVTTTTTTTWWWWWWWWVVSSSSSSSSSSSSWWWWWWWWYYYYNNNNNNNSSURRRRLLLGGGGBJJJZZZZAAAAAAAAAAABBBLLLLTTTTKKKTTTTTTTGGGGGGGCCCCGGTTWTTSSSGSNNN
RRRRRRLLLLLTTTTTTTTTWWTTTWVVVSSSSSSSSSSSSWWWWWWWWYYYYNNNSNNSSSSSSGGGGGGGGOJJQZZZZZVAAAAAAAAAVVVLLLLLTTTTKKKTTTTTTGGGGGGGGGGGGGGTTTTSSSSSSSNN
RRRRRRRLLLLTTTTTTTTTWTTTTTVVVSJSSSSDSSSSSSSWWWWWWYYYYNNSSSSSSSYYYGGGGGGGGGMJZZZZZZVVAAAAAAAVVVVLLLLLTTTKKKKKTTTTTGGGGGGGGGGGGGGTGGTSSSSSSSNN
RRRRRLRLLLLLLLTTTTTTTTTTTTVVVSJSSDDDSSSSSSSSTYYYYYYYYNNSSSSSSSGYGGGGGGGGGGGJJJJZZVVVAAAAAAAAAAVLLLLSSTTTTTKTTTTTTTGGGGGGGGGGGGGGGGSSSSSSNNNN
RRRLLLLLLLLLLTTTTTTTTTTTTTTTVJJJJJWDSSSSSSSSTTYYYYYYYNNSSSSSSSGGGGGGGGGGGGGGJJJZZZAAAAAAAAAAAAVLLLLSSTTTTTTTTTTTTTGGGGGGGGGGGGGGGGSSSSSSSNNN
RRRRRLLLLLLLTTYTTTTTTTTTTTTTVJJJJJDDSSSSSSTTTTYYYYYYYPPSSSSSSSGGGGGGGGGGGGGJJJJJJVVAAAVAAAAAAALLNLLNNNNTTTTTTTTTTATAGGGGGGGGGGGGGGLSSSSSSSNN
RRRRLLLLLLLLLTTTTTTTTTTTTKTTVJJJJJDDEEESSETTTTYYYYYKYPKSSSSSSSSGGSSSGGGGGGGGJJJJJVVVVVVVAAAAXXXLNNNNNKNNNNNTTTTTTAAAGGGGGGGGGGGGGLLSLLSSSSNN
RRRRLLLLLLLLLLWTTTTHTTTKKKTKKJJJJJJJHEESEEEYTKYGGGGKKKKSSSSSSSSGSSSSGGGGGGYGJJJJVVVVVVVVVAAXXXXLNNNNNKNNNNNNTTTAAAAAGGGGGGGGCGGGQCLLLLSSSSSS
RRRRLLLLLLLLLLLNRTTTTTTKKKKKKJJJJJJJJEEEEEYYTTAAAAAAAAAKSMSSSSSSSSSGGGGGGGGGGGGJVVVVVVVVKKXXXXXXNNNNNNNNNNNTTAAAAAAAGAGGGGGCCJGGQCLLLLSSSSSS
RRRRRLLLLLLNNXNNNMMMTTTKKKKKKJJJJJJJEEEEEEGGGGAAAAAAAAAKMMSSSSSSSSSGGGGGGGGGWWGVVVVVVVVVKKXGXXXNNNNNNNNNNNNAAAAAAAAAAAEGGCCCCCCCCCLLLLLSSSSS
RRRRRRLLLLLNNNNNNNMMMMMKKKKKKKJJJJJJJJEEEEENGGAAAAAAAAAKSSSSFFFFFFFSSZGGGGWWWWWVVVVVVVVVVKKXXXXNNNNNNNNNNNNAAAAAAAAAAAEAQCCCCCCCCCLLLLLSLSSS
RRRRRLLLNNLNNNNNNMMMKKKKKKKKKKKYJJJEEEEEEEENGGAAAAAAAAASSSSSFFFFFFFSGGGGWWWWWGGVVVVVVVVVVVVXXXXNNNNNNNNNNNNQQQQAAAAAAAAAAAACCCCCCCLLLLLLLSSS
RRRRRLLLLNNNNNNNNNNNKKKKKKKKKXKEJEEEEEEEEENNGGAAAAAAAAAJJSSSFFFFFFFSSSWWWWWWWWVVVVVVVVVVXXXXXXXXNNNNNNNNNNQQQQQAAAAAAAAALLACCCCCCCLLLLLLLTSS
RJZRQLLLAANNNNNNNNNKKKKKKKVKKKEEEEEEEEEEEEENNGAAAAAAAAAKSSSFFFFFFFFWWWWWWWWWWWWVVVVVVVVVXXXXXXXXNNNNNNNNNNQQQQQAAAAAAAAAAACCCCCCCCLLLLLTTTSS
JJJJJAALANNNNNNNNNNNKKKKKVVKKKKEEEEEEEEEEEEEEGAAAAAAAAAUSSSFFFFFFFFFFFWWWWWWWWWWVVVVVVZVVVXXXXXXNNNJNNNNNNNNQQAAQQQAAAAAACCCCCCCCCLLLTLTTTTT
JJJJJAAAANNNNNNNNNNNNKKVKVVVVVKEEEEEEEEEEEEEJJAAAAAAAAAUUUUFFFFFFFFFFFWWWWWWWWWWVVVVVZZVVVXXXXXXXXXXNJNNNNNNQQQQQQAAAAAAACCCCCCCCLLLTTTTTTTT
JJJJAAAAAOOONNNNNNNNNKKVVVVVVVVVEEEEEEEEEEEEJJAAAAAAAAAUUUUFFFFFFFFFFFWWWWWWWWWWVVVVVZVVVVVXXKXXXXXXXXNNNQQQQQQQQQQAAAAAAACCCCCCCLLTTTTTTTTT
JJJJJAAOOOOONNNNNNNNKKKVVVVVVVVVVEEEEEEEEEEEEJAAAAAAAAAUUUUFFFFFFFFFFFWWWWWWLLWVPVVVVVVVVVVXKKXXXXXXXXXQQQQQQQQQQQQAAAARQQCCCCCCCCCCTTTTTTTT
JJJJAAAAOOOOOOOOOONNKKKVVVVVVVVVVEEEEEEEEEEEEJJJMGGFFUUUUUNFFFFFFFFFFFWWWLLWLLTVVVVVVVVVVVVGGKKKKKKKJXXQQQQQQOQOQQQQQQAAQCCCCCCCCCGCTTTTTTTT
JJAAAAOOOOOOOOOOFFNNNVVVZZVVVVVVVVVFFEFFEEEEJJJMMMFFFFFFFFFFFFFFFFFFFFGWWLLLLLTVVVVVVVVVVVVGKKKKKKKQKKKQQQQQQOOOOQOOQQQQQCCCCCCCCGGGIITTTTTT
HJJAAAOOOOOOOOOOFFNNVVVVZZZZZZFVVVFFFFFFEEJJJJJMMMFFFFFFFFFFGGGGGFFFFFFFFFFLLLLLVVVVVVVVVVVVKKKKKKKKKKOOQQOUOOOOOOOQQQQQQQCCCCCCCIIIIIIIIITT
AJAAAAOOOOOOOOOOFFFNVVVVZZZZZZFFVFFFFFFFEEVJJJMMMMMFTFFFFFFFGGGGGFFFFFFFFFFLLLLLLVVVVVVVVVKVKKKKKKKKKOOOOOOOOOOOOOOQQQQQQQCCCCCCTTIIIIIIIITT
AAAAAAAOOOOOOOOOFFFFQQVVZZZZZZZFFFFFFFFFEEVVJJMMMMTTTFFFFFFFNNGGGGGGGFFFFFFLLLLLVVVVVVVVKKKKKKKKKKKKKOOOOOOOOOOOOOOOQQQQQQQQCQQFIIIIIIIITTTT
AAAAAAAOOOOOOOOOOOQFQQQZZZZZZZZZFFFFFFFFFVVVJJJJJTTTTTTTTCCNNNGGGGGGGFFFFFFLLLLLVVXOVVKKKKKKKKKKKKKKKKOOOOOOOOOOOOOQQQQQQQQQQQQFIIIIIIIIITTT
AAAAAAAAOOOOOUOOOOQQQQQQZZQZZZQFFFFFFFFVVVVVVJJJTTTTTTTTTCCGGGGGGGGGFFFFFFFLLLLLOOOOOVVKVKKKKKKKKKKKKKOOOOOOOOOOOOJJJJJJQQQQQQFFFIIIIIIIIITT
AAAAAAAOOOUOOUOQQQQQQQQQQQQQQQQQFFFFJJFJJJVVVJJJTTTTTTTTTTCCGGGGGGGGFFFFFFLLLLLLOOOOOVVVVKOKKKKJKKKKKKOOOOOOOOOOOJJJJJJJQQQQQQFFFFIIIIIITTTT
AAAAAAAAOOUUUUUTQQQQQQQQQQQMQQQQQFFJJJJJJJVVVJJTTTQTTTTTTTCGGGGGGGGGFFFFFFFFFYLOOOOOOVVVVVKKKKJJKKKKKKOOOOOOOOOOOOJJJJJJJJQQFFFFFFIIIIITTTTT
AARAAAAAOUUTUTTTTQQQQQQQQQQQQQQQQFFJJJJJJJVVVJJJJJTTTTNNNNNFGGGGGAGGFFFFFFFFFYOOOOOOBVVVVVJJJJJJJJJJOOOOOOOOMMOOOJJJJJJJJJQFFFFFFFIIIIITTTTT
AAAQQAAAATTTTTQQQQQQQQQQQQQQQQQZZJJJJJJJJJVVVJJJJJTTHHHHHNFFRFGAAAAAAAAAFFFFFOOOOOOOOOJJJJJJJJJJJRJJJJJOOOMJMMOOOJJJJJJJJJFFFFFFFIIIIITTTTTT
AQQQQQAAAATTTTQQQQQQQQQQQQQQQQQZJJJJJJJJJJJJJJJJJJJTHHHHHFFFFFAAAAAAAAAAFFFFFOOOOOOOOOJJJJJJJRRRRRJJJOOOOOMMMMMMMJJOJJJJJJJFFFFGGLIIIGGTTTTT
QQQQQVVAVATTTTQQQQQQQQQPPPPPQZQZZZZZJJJJJJJJJJJJJJJJHHHHHFFFFFFFAAAAAAAAFFFFFAAAAAAOOOJJJJJJJRRRRRRJJJOOOOOMMMMMMMCJJJJJJJJFFFFGGGIIIGTTTTTT
QQQQQQVVVVKKTTQQQVVQQQQQQAPLZZZZZZAZJJJJJJJJQQJQJJJJHHHHHFFFFFFFFAAAAAAAFFFFFAAAAAAOJJJJJJJJJRJRRJJJJJOOJJOMMMMMMMMMMJJJJJJGGGGGGEEEGGGTTTTT
QQQQQQVVVVVVVVVVVVVQQQQQQALLLLPZZAAAJJJJJQQQQQQQQJJJHHHHHFFFFFFFFAFQQAQAFFFFFAAAAAAOOJJJJJJJJJJRRJJJJJJJJJOOMMMMMMMJJJJJJJUUGGGGGEEGGGTTTTTT
QQQQQQVVVVVVVVVVVVVQQQQQQQLLLPPZAAAAJJJJQQQQQQQQQQQJHHHHHFFFFFFBFFFQQQQQFFFFFAAAAAAOOOFJJJJJJJJJJJJJJJJJJJOOMMMMMMMMMMMJJUUGGGGGGGGGGGTTTTTT
SSSQQSFVVVVVVVVVVVVVVQQQQLLLHHHAAAAAARJAAOQQQQQQQQQQHHHHHFFFFFFFFFFQQQQQQAAAAAAAAAAFFFFJJJJXJJJJSJJJJJJJJJOOMMMMMMMMMMMMMUUGGGGGGGGGGGGTTTTT
PSSSSSSVVVVVVVVVVVVVVLLLQQLLHHHPAAPPPRROOOOOQQQQQQQQHHHHHFFFFFFFFFMQQQQQQAAAAAAAAAAFFFFFFFXXXXJSSSJJJJPJOOOOOMUMMMMMMMMMMMUGGGGGGGGGGGGGTOTO
SSSSSSSSSVVVVVVVVVVVVLLLQQLLHHHPPPPPRROOOOOOOOQQQQQQHHHHHFFFFFFFGGGQQQQQQAAAAAAAAAAFFFFFFFXXXXSSSJJJOOJJJOOOOMMMMMMMMMMMUUUGGGGGGGGGGGGTTOOO
SSSSSSSSSSSVVVVVVVVVLLLLLQLLHHHHHHPPOOOOOOOOQQQQQQQGGGGGGFFFFFFGGQGQQQQQQAAAAAAAAAAFFFFFFFXXXSSSTJJJOOOOOOOOOMMMMUMUMUMMUGGGGGGGGGGGGGGGGOOO
SSSSSSSSSSVVVVVVVVVVVQQLLLLLHHHHHHPOOOOOOOOOOQQQQQQGGGGGGFFFFGGGGQQQQQQQQAAAAAAAAAAFFFFFFXXXLSSSSJJYOOOOOPOOOOMMMUUUUUUUUGGGGGGGGGGGGGGGGOOO
SSSSSSSSSSVVVVVVVVVNNQQLLLLPHHHHHHOOOOOOOOOOQQQQQQGGGGGGGFFFFGGGQQQQQQQQQAAAAAAAAAAFFFFFFXZXSSSSSTYYOYHOPPOOOMMQQQUUUUUUUGGGGGGGGGGGGGOGGOOO
SSSSSSSSSSVVVVVVVQVVQQQQQLLLLHHHHHOOOOOOOOOOOOQQQQGGGGGGGGFFGGGGQQQQMMQQQQQQQYYYYYYFFFFFZZZXYSSSSYYYYYYYPQQQQQQQQQQQQUUUGGGGGFNGGGGGGGOOOOOO
SSSSSSSSSSVVVVVVVQNNQQQQLLLLLLZOOOOOOOOOWWOOOQQQQQQQQGGGGGGGGGGGGGGGMMMMQQQQQYYYYYYFFFFFZZZYYSSSSYYYYYYYQQQQQQQQQQQQQLLUGFFGGFGGEOGGOOOOOOOO
SSSSSSSSSSVVVVVVVQQQQQQQQLLLLZZOOOOOOWOWWWOOOQQQQQQQQQQGGGGGGGGGGGGGMMMMQQYYYYYYYYYFFFFFYZYYYYYSYYYYYYYYQQQQQQQQQQQQQZLULLFFFFGGOOOGOOOOOOOO
SSSSSSSSSSSVVQQVVVQQQQQQQUUUZZZZZOOOOWWWWWWWOOOQQQQQQQQGQQGGGGGGGGGMMMMMMMYYYYYYYYYYYFLLYYYYYYYYYYYYYYYYQQQQQQQQQQLQLLLLLLFFFFGFFOOOOOOOOOOO
SSSSSSSSSSMVVQQQQQQQQQUUQUUUUZZZZZZOOWWWWWWWEEEPQQQQQQQQQQGGGGGGGGGMMMMMMMMMMYYYYYYYYYYYYYYYYYYYYYYYYYYYYQQQQQQQLLLLLMLLLLLLLFFFFFOOOOOOOOOO
FSSSSSSSSSMVVQQQQQQQQUUUUUUUUZZZZZZWWWWWWWWWEPPPPPPQQQQQQQGGGGGGGGMMMMMMMMMMYYYYYYYYYYYYYYYYYYYYYYYYYYYYQQQQQQQQQQLLLLLLLLLLLFFFFOOOOOOOOOOO
FIIIAASSSMMMQQQQQQQQQUUUUUUUVZZZZWWWWWWWWWWEEPPPPTPPQQQQQQGGQGGGGGGMMMNMMYYYYYYYYYYYYYTTVYYYYYYYUYYYYYYYQQQQQQQQQQQLLLLLLLLLLFFFSSOOOOOOOOOO
FFIIIISSMMMQQQAQQQQQQQQUUUUUVVZZZWWWWWWWWWWPPPPPPPPQQQQQQQQQQQGGGGGMMMMMYYYYYYYYYYYYYYTTVYYYYUYYUUYYYYYYYQQQQQQQQQLLLLLLLLLLLFEESSAWWOOOOOOL
IIIIMMMMMMMMMMQQQQQQQQQUUULQQVVQAWWWWWWWWPPPPPPPPPPQQQQQQQQQQGGGGGGMMMMMTYYYYYYYYYYYYYTTVYZYYUUUUUUUYYYYQQQQQQQQQQLXLLLLLLLLEEEESSAWWWOOLLLL
QQIIIQQMMMMMMMQQQQQQQQQUUKKQQQQQQQWWWWWWWPPPPPPPPPPQQQQQQQQQQGGGGGGMFMMMTYYYYYYYYYYYYTTTTTYYYUUUUUUUUYYYYQQQQQQQQQQQLLLLLLLLLEEEEEAWWWWOLLLL
QQIIQQQMMMMMMMMKKKKKKKKKKKKQQQQQQQKWWWWJWPPPPPPPPPPQEQQQQQQQQQGGGWGGGMMMTTTTYYYYYYYYTTTTTTYYYUUUUUUUUYYYQQQQQQQQQXXLLLLLLLLLLLEEEEAWLWWLLLLL
QQIQQQQQQMMMMMMKKKKKKKKKKKKQQQQQWWWWWWWJPPJJPPPPPPPPQQQQQQQQQQGGCGGGCMMMMKKYYYYYYYYTTTTTTTTTULUUUUUUUYYYYQQQQQQQXXXXKXLGGGGLLLEEEEALLWLLLLLL
QQQQQQQQQQMQMMKKKKKKKKKKKRQQQQQQQWWWWJJJJJJJJPPPPPPQQQQQQQQQQQGGCCGGGAMKKKKYYYKYYYYTTTTTTTTTUUUUUUUUUYYYYYQQQXXXXXXXXXXGGGGLLEVEEAALLLLLLLLL
QQQQQQQQQQQQQMMKKKKKKKKKKKQQQQQQQWWWWWJJJJJJJJJPPPPQQQQDDDDDQQQQCCCGGKMKKKKKKKKYYYYITTTTTTTTUUUUUUUUUUYYYQQQQQXXXXXXXXXGGGGGGGGGLLLLLLLLLLLL
QQQQQQQQQQQMMMKKKKKKKKKKKKYQQQQQQQQJJJJJJJJJJJPPPDDDDDDDDDDDYXXPPPPPPKKKKKKKKKKKYYNNTTTTTTTUUUUUUUUULLUUYYQQQQSXXXXXXXXGGGGGGGGGLULLLLLLLLLL
QQQQQQQQQQQMMMKKKKKKKKKKKYYQQQQQQQJJJJJJXJJJJPPPPDDDDDDDDDDDDDDDYPPPPKKKKKKKKKKKYYNNTTTTSTTTUUUUUUUUUUUUUUQQSSSXXXXXXXXGGGGGGGGGUULLLLLLLLLL
QCCQQQQQQQQQMMMMKKKKKKKKKYYQQQQQQCJJJXXXXXXXXPPPPDDDDDDDDDDDDDDDBBPPKKKKKKKKKKKKKKNTTNNPSSSSUUUUUUUUUUUUSSSSSSSSSXGGGGGGGGGGGGGGUUULLUULLLLL
CCCCCCQQQQQQQQMMKKKGKKKKYYYYYYQQQCJJJXXXXXXDDDDDDDDDDDDDDDDDDDDDYBPPKKKKKKKKKKKKKKNNTNPPPSPSPUUUUUUUUUUUUSSSXXXSFXGGGGGGGGGGGGGGUUUUUUAAAALL
CCCCCQQMMMQMMMMMQKGGGKKKYYYYYYNNNJJJJXXXXXXDDDDDDDDDDIQDDDDDYYYJYYYKKKKKKKKKKKKKKKKNNNPPPPPSPPPPPPIUUUUUUUUSXXXXXXGGGGGGGGGGGGGGEEEUUUAAAALL
TTCCCCCSMMMMQMQQQGGGGBBBYYYYNNNNNNJJXXXXXXXDDDDDDDDDDEQDDDDDYYYYBBBBKKKKKKKKKKKKKKKNNPPPPPPPPPPPPPPUUUUUSSSSXXXXXXGGGGGGGGGGGGGGOEEUUUUAAALN
TTTTCCSSMQQQQQQQQQGGGBBBBYYNNNNNNNNNNXXXXXXDDDDDDDDDDEQDDDDDBBBBBBBBKKKKKKWWBBKKNOKNNNPPPPPPPPPPPPUUUUUSSSSSSXXXXXXXXXXXXXEEEEEOOQUUUQQQAANN
TTTTCCSSSSUQQQQQQQQBBBBBYYNNNNNNNNNXXXXXXXXDDDDDDDDDDEEDDDDDBBBBBBBIKWWWWWWWWWKKNNNNNNPPPPPPPPPPPPPUUUSSSSSSXXXXXXXXXXLXXXEEEEEOOQQQQQQQNNNN
TTTTTCSSSSSQQQQQJJBBBBBBBYNNNNNNNNNXXXXXXXXXXXXDDDDDEEEDDDDDBBBBBBIIIWWWWWWWWDKNNNNNNNNPPPPPPPPPPSSUSSSSSSSSXXSXXXXLLXLLXXEEEEEEQQQQQQQQNNNN
TTTTTCCSSSSSQQQQQQBBBBBBBYNZNNNNNNNNNNNNNXXXXXXDDDDDDDDDEBBBBBBBBBIIWWWWWWWWDDDDNNNNNNNPPPPPPPPSSSSSSSSSSSSSSSSSXXSSSXLLEEEEEEEEEEQQQQQGNGGG
TTTTTCCSSSSSQQQQBBBBBBBBYYNZNFFNENNUUNNNNXXXXXXDDDDDDDDDBBBBBBBBBBIIWWWWWWWWDZDNNMNNNNNPPPPPPPPSSSYSSSSSSSSSSSSSSSSSSLLLEEEEEEEEJJQQGGGGGGGG
TTTTCCCCCSSSQSQQSSBBBBBYYMMZZNNNNNNUNNNNNNNUUXEDDDDDDDDDBBBBBBBBBBIWWWWWWWWZZZZNNMMNNNNGPPPGSSSSSYYYYYSSISSSSSSSSISSSSSLEEOEEEEEEJJJGGGGGGGG
CCTCCCPPPSSSSSSSSSRRBBBYMMMZNNNNNNNNNNNNNNNUNNEDDDDDDDDDBBBBBBBBBIIWWWWWWWWZZZZZZNNNNZGGGPGGGSSSSYYYYSSSIIIIIIIIIIISQQSQSEOOEEEEJJJJGGGGGGGG
CCCCCCPPPPSPSSSSSSSRRRBYMMMMEENNNNNNNNNNNNNNNNEDDDDDDDDDBBBBBBBBBIIWWWWWWWWZZZZZZZZZZZGGGGGGYYYYYYYSSSSSIIIIIIIIIIIXQQQQQOOOOGEEJCJGBGGGGGGG
CCCCCCPPPPPPPPPPRRRRRRMMMMMMMMMNNNNNNNNNNNNNNEEDDDDDDDDDBBBBBBVBBBBBWWWWWWZZZZZZZZZZZZZGWGGGYYYYYYYYYSSSIIIIIIIIIXXXXQQQQOOOMCCCCCGGGGGGGGGG
UUCCCPPPPPPPPPPRRRRRRRMMMMMMMMNNNNNNNNQNNNNNNEEDDDDDDDDDBBBBBBVBBBBBWWWWWWZZZZZZZZZZZZWWWYGGYYYYYYYYYSSSIIIIIIIIIXXXQQQQQOOOCCCCCKKGHCGGGGGG
UUUUPPPPPPPPPPRRRRRRRRMMMMMMMMMMMNNNMNQQQNNNEEEEEEEEEEBBBBBBVVVVVBBBBWWWWWSZZZZZZZZZZZWWWYYYYYYYYYYYYYYSIIIIIIIIIXXQQQQOQOOOOCCCCCKCCCGGGGGG
UUUPPPPPPPPPPPRRRRRRRRRRMMMMMMMMNNNMMQQQQQBEEEEEEEEEEESBBVVVVVVVVVBVWWWWWWWZZZZZZZZZZZZWWYYYYYYYYYYYYYYIIIIIIIIIIIQQQQOOOOOOOCCCCCCCCGGGGGGG
UUUUUPPPPPPPPPRRRRRRRRRRMMMMMMMMMMMMMMQQQBBBBEEEEEEEESSSSLLVVVVVVVVVWWWWWWYZZZZZZZZZZZZZWYYYYYYYYYYYYYYYIIIIIIIIIICCCQQLOOOLCCCCCCCCCGGGGGGG
UUUUPPPPPPPRRPPRRRRRRRMRMMMMMMMMMMMMJMQQQQQBQQEEEEEEESSSSSSVVVVVVVVVVWWWCWZZZZZZZZZZZZZZWYWWYYYYYYYYYYYYTIIIIIIIIIIICQQLLLOLLCCCCCCCCCGGGGGG
UUUUPPPPPPRRRRRRRRRRRMMMMMMMMMMMMMMXXXXQQQQQQQEEEEESSSSSSSSSSVVVVVVVVSSIIWWZZZZZZZZZZZZZWWWWWWYYYYYYYBYYYIIIIIIIIIIIZZZZZLLLLCCCCCCCCCCGGGGG
UUUUXXPPXPPRRRRRRRRRRMMMMMMMMMMMMMMMXXXQQQQQQEEEEEESSSSSSSSSSSVVVVVHHIIIIZZZZZZZZZZZZZZWWWWWWYYYYYYYYYYYYYIIIIIIIIIZZZZZZLLLCCCCCCCCCCGGGGGG
UUUXXXXXXPPRRRRRRRRRRMRRMMMMMMMMMMMXXXXXQQQQQEEEEEEEQSSSSSSSSSSUVVVHHIIIIZZZIAZZCZZMZDDDDDDDWWYYYNNYYYYYYNIIIIIIIIIZZZZZLLLLCCCCCCCCCGGGGGGG
XXXXXXXGRRRRRRRRRRRRRRRRMMMQMMMMMMXXXXXXQQQQQQQEEQEEQQSSSSSSSSSUUUMMMIIIIIIIIICCCZZDDDDDDDDDWWYYYYNNYYYYYNNIIIIZZZIZZZLLLLLCCCCCCCCCCCGGGGGG
XXXXXXXGRRRRRRRRRJRRRRRRRRMQMMMMMJXXXXXXXQTTTQQQQQQQQQSSSSSSSSSSUMMMIIIIIIIIIICCZZZDDDDDDDDDWWWYPUNNNYYYYNIIIIIZZZZZZZZLLLLCCCCCCCCCCCGGGGGG
XXXXXXGGGRRRRGJJJJRRRRRRRJJMMMMJJJTXXXXXQQTTTQQQQQIIQQSSSSSSSSSSSMMMMIIIIIIIIIZZDDDDDDDDDDDDWWWPPUNNNNNNNNNNZZZZZZZZZZLLCCLCCCCCCCCCCGGGGGGG
XBBBXGGGGRGRGGUJJJJJRJRRRJJMMJJJJTTTXXXXQTTTTTTQQQIIISSSSISSSSSSSMMMMIIIIIIIIIZZDDDDDDZWDDDWWPPPUUNNNNNNNNNNNZZZZZZZZZZRRCCCCCCCCCCCSSGGGGGG
XBBBGGGGGGGGGGGGJJJJJJRJJJJJJJJJTTTTXXXXTTTTTTTQQIIGGSSSSISSSSMSSMMMMIIIIIIIIIZZDDDDDDZWDDDWWPPPUUNNNNNNNNNNNNNZZZRRZZZZRCCKCCCCCCCCCSSGGGHZ
BBBBGGGGGGGGGGGEJJJJJJJJJJJJJJJTTTTTTTXXTTTTTTTIIIIGIZZIIIISSSMMMMMMMMIIIIIIIIZZDDDDDDWWDDDWWPPPUUUNNNNNNNNNNNNZFZRRRRRRRRRKCCCCCCCCCCCGGGGZ
BBBGGGGGGGGGGGGGJJJJJJJJJJJJJJJJTTTTTTTTTTTTTTTIIIIIIIIIIIVVSMMMMMMMMMIIIIIIIIZZDDDDDDWWDDDWWWPUUUUNNNNNNNNNNNXFFFFRQRRRRRRCCRRCYYCLLLCZZZZZ
BBBGGGGGGGGGGJJGGJJJJJJJJJJJJJJJTTTTTTTTTTTTIIIIIIIIIIIIIIVISMMMMMMMMMIIIIIIIIIZZZZZZZZZDDDWWWWQQNNNNNNNNNNNNNXFFFFRRRRRRRRRRRRRRRCLZZZZZZZZ
BBBBGGGGGGGGGGJJJJJJJJJJJJJJJJJJJTTTTTTTTTTTTIIIIIIIIIIIIIIIMMMMMMMMVVJJJIIIIIIIIZZZZZZZWWWWWWQQQNNNNNNNNNNNNNXFRRFRRRRRRRRRRRRRRRRLZZZZZZZZ
BBBBBGGGGGGGGGJJJJJJJJJJJJJJJJJJJJJTTTTTTTTTTIIIIIIIIIIIIIIIIMMMMMMMMJJJJJJIIIIIIZZZZZZZWWWWWWQQQNNNNNNNNNNNNXXFXRRRRRRRRRRRRRRRRCCYSYZZZZZZ
BBBBGGGGGGGGGGGGJJJJJJJJJJJJJJJJJJJTTTTTTTTTTTIIIIIIIIIIIIIIIMMMMMMMMJJJJJJIIIIIIIIDZZZNWWWWWWQQNNNNNNNNNNNXNXXFXVVRRRRRRRRRRRRRRRRYYYYYZZZZ
BBGGGGGGGGGGGGGGGGCCCJJRJJJJJJJJJJTTTTTTFTTTTTIIIIIIIIIIIIIIIMMMMMJJJJJJJJJIIIIIIDDDZZZMWWWWWWWGGNHNNNNNNNNXXXXXXXRRXRRRRRRRRRRRRRRYYYYYZZZZ
BBBBBGGGGGMMMGOUUGCCJJYJJJJJJJJJTTTTTTTFFFTTTTIIIIIIIWIIIIIINMMMMMJJJJJJJJJIIIIIIIIDDMMMMXWWGGGGGGNNNNNNNNXXXXXXXXUXXIRRRRRRRRRRRYYYYYYZZZZZ
BBBBBBBGGGMMMUUUUUCCCNJJJJJJJJJJJJTTTFFFFFFFTTTWIIIIIWIIIIIINNMMMMMJJJJJJJJJTJIIIDDDDMMMMXLGVGGGGGGNNNXXXXIXXXXXXXXXXIRRXRRRRRRRYYYYYYYYZZZZ
BBBBBBGGGGMMMUUUUUUUUUJJJJJJJJJJJJTTTTFFFFFFQFEWIIIIWWIIIIIINMMMMMJJJJJJJJJJJJIDDDDDMMMMMXLGGGGGGGGGGNGXXXXXXXXXXXXXXIIXXRRRRRRRYYYYYYYYYZZZ
BBBBBBBBFFFMUUUUUUUUUUJJJJJJJJJJJJJGJJFFFFFFFFEWWWWWWWIWIIIIJJJMJJJJJJJJJJJJJJJDDDDDMMMMUXLGGGGGGGGGGNGXXXXXXXXXXXXXIIIXXRRRRRYYYYYYYYYYYYYY
BBBBBBFFFFFFFUUUUUUUUUJJJJJJJJJJJJJJJFFFFFFFFFFPWWWWWWWWIDDIJJJJJJJJJJJJJJJJDDDDDLLLLMUUUXGSGGGGGGGGGGGGXXXXXXXXXXXXIIIXXYRRRRYYYYYYYYYYYYYY
BBBBBBFFFFFFFFUUUUUUUUJJJJJDJVJJJJJJJFFFFFFFFFFWWWWWWWWWUJJJJJJJJJSSJJJJJJJJDDDDLLLLLUUUUUGGGGGGGGGGGGGGGXXXXXXXXXXXIXXXXYRRRYYYYYYYYYYYYYYA
BBBBBBBBFFFFFFFUUUUUUUJJZJJJJJJJJJJJFFFFFFFFFFFQWWWWWWWWUUJJJJJSSSSJJJJJJJJJDDDDLLLLLLLUUGGGGGGGGGGGGGGGGXOXXXXXXXXXXXXXXXXXRYYYYYYYYYYYYYYY
BBBBBBBFFFFXFUUUUUUUUUZZZJZZUJJJJJJJJJJJFFFFFFFQWWWWWWWWWUJJJLJJSSSSSSSJJJJJDLLLLLLLLLLLGGGGGGGGGGGGGGGGGXOXXXXXXXXXXXXXXXXWXYYYYYYYYYYYYYYY
BBBBBBBBUUUUUUUUUUUUUZZZZZZZUUJJJJJJJJFFFFFFFFFFMWWWWWWXXXUUJLLLLLSSSSSJJJDDDDLLLLLLLLUGGGGGGGGGGGGGGGGGGGGXXXXXXXXXXXXXXXXXXYYYYYYYYYYYYYYY
BCBUUUBUUUUUUUUUUUUUZZZZZZZUUUJJJJJJJFFFFFFFFFFMMXXXWXXXXXUUJDLLLLSSSSSSJJJDDDDLDDLUUUUGGGGGGGGGGGGGGGGGGGGXXXXXXXXXXXXXXXXXXYYYYYYYYYYYYYWY
BCCUUUUUUWUUUUUUUUUUZZZZZZZZUUUUJJJJBFFFFFFFMMMMMMXXXXXUUUUUULLLLLSSSSSSJJJDDDDDDDDDURGGGGGGGGGGGGGGGGGGGGXXXXXXXGGXXXXXXXXXXYYYYYYYYYYYYYWW
""".trimIndent().split("\n")