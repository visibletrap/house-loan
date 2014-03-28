(ns house-load.analyze)

(def bbl '(["31011996" "13.7500"] ["29021996" "13.7500"] ["31031996" "13.7500"] ["30041996" "13.7500"] ["31051996" "13.2500"] ["30061996" "13.2500"] ["31071996" "13.2500"] ["31081996" "13.2500"] ["30091996" "13.2500"] ["31101996" "13.2500"] ["30111996" "13.2500"] ["31121996" "13.2500"] ["31011997" "13.2500"] ["28021997" "13.2500"] ["31031997" "13.2500"] ["30041997" "13.2500"] ["31051997" "12.7500"] ["30061997" "12.7500"] ["31071997" "13.7500"] ["31081997" "13.7500"] ["30091997" "14.2500"] ["31101997" "14.7500"] ["30111997" "14.7500"] ["31121997" "15.2500"] ["31011998" "15.2500"] ["28021998" "15.2500"] ["31031998" "15.2500"] ["30041998" "15.5000"] ["31051998" "15.5000"] ["30061998" "15.5000"] ["31071998" "15.5000"] ["31081998" "15.0000"] ["30091998" "14.5000"] ["31101998" "13.7500"] ["30111998" "12.0000"] ["31121998" "11.5000"] ["31011999" "11.0000"] ["28021999" "10.5000"] ["31031999" "9.7500"] ["30041999" "9.7500"] ["31051999" "9.5000"] ["30061999" "8.7500"] ["31071999" "8.7500"] ["31081999" "8.7500"] ["30091999" "8.5000"] ["31101999" "8.2500"] ["30111999" "8.2500"] ["31121999" "8.2500"] ["31012000" "8.0000"] ["29022000" "8.0000"] ["31032000" "8.0000"] ["28042000" "8.0000"] ["31052000" "8.0000"] ["30062000" "8.0000"] ["31072000" "8.0000"] ["31082000" "8.0000"] ["29092000" "7.7500"] ["31102000" "7.7500"] ["30112000" "7.7500"] ["29122000" "7.7500"] ["31012001" "7.7500"] ["28022001" "7.2500"] ["30032001" "7.2500"] ["30042001" "7.2500"] ["31052001" "7.2500"] ["29062001" "7.2500"] ["31072001" "7.2500"] ["31082001" "7.2500"] ["28092001" "7.2500"] ["31102001" "7.2500"] ["30112001" "7.2500"] ["28122001" "7.0000"] ["31012002" "7.0000"] ["28022002" "7.0000"] ["29032002" "7.0000"] ["30042002" "7.0000"] ["31052002" "7.0000"] ["28062002" "7.0000"] ["31072002" "7.0000"] ["30082002" "7.0000"] ["30092002" "7.0000"] ["31102002" "6.7500"] ["29112002" "6.7500"] ["27122002" "6.7500"] ["31012003" "6.7500"] ["28022003" "6.7500"] ["31032003" "6.5000"] ["30042003" "6.5000"] ["30052003" "6.5000"] ["30062003" "6.2500"] ["31072003" "5.7500"] ["29082003" "5.7500"] ["30092003" "5.7500"] ["31102003" "5.7500"] ["28112003" "5.7500"] ["31122003" "5.7500"] ["30012004" "5.7500"] ["27022004" "5.7500"] ["31032004" "5.7500"] ["30042004" "5.7500"] ["31052004" "5.7500"] ["30062004" "5.7500"] ["30072004" "5.7500"] ["31082004" "5.7500"] ["30092004" "5.7500"] ["29102004" "5.7500"] ["30112004" "5.7500"] ["30122004" "5.7500"] ["31012005" "5.7500"] ["28022005" "5.7500"] ["31032005" "5.7500"] ["29042005" "5.7500"] ["31052005" "5.7500"] ["30062005" "5.7500"] ["29072005" "5.7500"] ["31082005" "5.7500"] ["30092005" "6.0000"] ["31102005" "6.2500"] ["30112005" "6.2500"] ["30122005" "6.5000"] ["31012006" "6.7500"] ["28022006" "6.7500"] ["31032006" "7.2500"] ["28042006" "7.5000"] ["31052006" "7.5000"] ["30062006" "7.5000"] ["31072006" "7.5000"] ["31082006" "7.5000"] ["29092006" "7.5000"] ["31102006" "7.5000"] ["30112006" "7.5000"] ["29122006" "7.5000"] ["31012007" "7.5000"] ["28022007" "7.5000"] ["30032007" "7.5000"] ["30042007" "7.2500"] ["30052007" "7.0000"] ["29062007" "7.0000"] ["31072007" "6.8750"] ["31082007" "6.8750"] ["28092007" "6.8750"] ["31102007" "6.8750"] ["30112007" "6.8750"] ["31122007" "6.8750"] ["31012008" "6.8750"] ["29022008" "6.8750"] ["31032008" "6.8750"] ["30042008" "6.8750"] ["30052008" "6.8750"] ["30062008" "7.2500"] ["31072008" "7.2500"] ["29082008" "7.2500"] ["30092008" "7.2500"] ["31102008" "7.2500"] ["28112008" "7.2500"] ["30122008" "6.7500"] ["30012009" "6.5000"] ["27022009" "6.5000"] ["31032009" "6.0000"] ["30042009" "6.0000"] ["29052009" "5.8750"] ["30062009" "5.8750"] ["31072009" "5.8750"] ["31082009" "5.8750"] ["30092009" "5.8750"] ["30102009" "5.8750"] ["30112009" "5.8750"] ["30122009" "5.8750"] ["29012010" "5.8750"] ["26022010" "5.8750"] ["31032010" "5.8750"] ["30042010" "5.8750"] ["31052010" "5.8750"] ["30062010" "5.8750"] ["30072010" "6.0000"] ["31082010" "6.0000"] ["30092010" "6.0000"] ["29102010" "6.0000"] ["30112010" "6.0000"] ["30122010" "6.1250"] ["31012011" "6.3750"] ["28022011" "6.3750"] ["31032011" "6.6250"] ["29042011" "6.7500"] ["31052011" "6.7500"] ["30062011" "6.8750"] ["29072011" "7.1250"] ["31082011" "7.1250"] ["30092011" "7.2500"] ["31102011" "7.2500"] ["30112011" "7.2500"] ["30122011" "7.2500"] ["31012012" "7.2500"] ["29022012" "7.1250"] ["30032012" "7.1250"] ["30042012" "7.1250"] ["31052012" "7.1250"] ["29062012" "7.1250"] ["31072012" "7.1250"] ["31082012" "7.1250"] ["28092012" "7.1250"] ["31102012" "7.0000"] ["30112012" "7.0000"] ["28122012" "7.0000"] ["31012013" "7.0000"] ["28022013" "7.0000"] ["29032013" "7.0000"] ["30042013" "7.0000"] ["31052013" "7.0000"] ["28062013" "7.0000"] ["31072013" "7.0000"] ["30082013" "7.0000"] ["30092013" "7.0000"] ["31102013" "7.0000"] ["29112013" "7.0000"] ["27122013" "6.8750"] ["31012014" "6.8750"] ["28022014" "6.8750"]))
(def boa '(["31011996" "13.7500"] ["29021996" "13.7500"] ["31031996" "13.7500"] ["30041996" "13.7500"] ["31051996" "13.7500"] ["30061996" "13.7500"] ["31071996" "13.7500"] ["31081996" "13.5000"] ["30091996" "13.5000"] ["31101996" "13.5000"] ["30111996" "13.5000"] ["31121996" "13.2500"] ["31011997" "13.2500"] ["28021997" "13.2500"] ["31031997" "13.2500"] ["30041997" "13.0000"] ["31051997" "12.7500"] ["30061997" "12.7500"] ["31071997" "13.7500"] ["31081997" "13.7500"] ["30091997" "14.2500"] ["31101997" "14.7500"] ["30111997" "14.7500"] ["31121997" "15.2500"] ["31011998" "15.2500"] ["28021998" "15.5000"] ["31031998" "15.5000"] ["30041998" "15.5000"] ["31051998" "16.0000"] ["30061998" "16.0000"] ["31071998" "16.0000"] ["31081998" "15.5000"] ["30091998" "15.0000"] ["31101998" "14.7500"] ["30111998" "13.0000"] ["31121998" "12.0000"] ["31011999" "11.5000"] ["28021999" "10.5000"] ["31031999" "10.0000"] ["30041999" "9.7500"] ["31051999" "9.7500"] ["30061999" "9.2500"] ["31071999" "9.2500"] ["31081999" "9.2500"] ["30091999" "9.2500"] ["31101999" "8.7500"] ["30111999" "8.7500"] ["31121999" "8.7500"] ["31012000" "8.5000"] ["29022000" "8.5000"] ["31032000" "8.5000"] ["28042000" "8.5000"] ["31052000" "8.5000"] ["30062000" "8.5000"] ["31072000" "8.5000"] ["31082000" "8.5000"] ["29092000" "8.2500"] ["31102000" "8.2500"] ["30112000" "8.2500"] ["29122000" "8.2500"] ["31012001" "8.2500"] ["28022001" "7.7500"] ["30032001" "7.7500"] ["30042001" "7.7500"] ["31052001" "7.7500"] ["29062001" "7.7500"] ["31072001" "7.7500"] ["31082001" "7.7500"] ["28092001" "7.7500"] ["31102001" "7.7500"] ["30112001" "7.7500"] ["28122001" "7.5000"] ["31012002" "7.5000"] ["28022002" "7.2500"] ["29032002" "7.2500"] ["30042002" "7.2500"] ["31052002" "7.2500"] ["28062002" "7.2500"] ["31072002" "7.2500"] ["30082002" "7.2500"] ["30092002" "7.2500"] ["31102002" "7.0000"] ["29112002" "7.0000"] ["27122002" "7.0000"] ["31012003" "7.0000"] ["28022003" "7.0000"] ["31032003" "6.7500"] ["30042003" "6.7500"] ["30052003" "6.7500"] ["30062003" "6.5000"] ["31072003" "5.7500"] ["29082003" "5.7500"] ["30092003" "5.7500"] ["31102003" "5.7500"] ["28112003" "5.7500"] ["31122003" "5.7500"] ["30012004" "5.7500"] ["27022004" "5.7500"] ["31032004" "5.7500"] ["30042004" "5.7500"] ["31052004" "5.7500"] ["30062004" "5.7500"] ["30072004" "5.7500"] ["31082004" "5.7500"] ["30092004" "5.7500"] ["29102004" "5.7500"] ["30112004" "5.7500"] ["30122004" "5.7500"] ["31012005" "5.7500"] ["28022005" "5.7500"] ["31032005" "5.7500"] ["29042005" "5.7500"] ["31052005" "5.7500"] ["30062005" "5.7500"] ["29072005" "6.2500"] ["31082005" "6.2500"] ["30092005" "6.5000"] ["31102005" "6.5000"] ["30112005" "6.5000"] ["30122005" "6.7500"] ["31012006" "7.0000"] ["28022006" "7.0000"] ["31032006" "7.5000"] ["28042006" "7.7500"] ["31052006" "7.7500"] ["30062006" "7.7500"] ["31072006" "7.7500"] ["31082006" "8.0000"] ["29092006" "8.0000"] ["31102006" "8.0000"] ["30112006" "8.0000"] ["29122006" "8.0000"] ["31012007" "8.0000"] ["28022007" "8.0000"] ["30032007" "7.7500"] ["30042007" "7.5000"] ["30052007" "7.2500"] ["29062007" "7.2500"] ["31072007" "7.1250"] ["31082007" "7.1250"] ["28092007" "7.1250"] ["31102007" "7.1250"] ["30112007" "7.1250"] ["31122007" "7.1250"] ["31012008" "7.1250"] ["29022008" "7.1250"] ["31032008" "7.1250"] ["30042008" "7.1250"] ["30052008" "7.1250"] ["30062008" "7.5000"] ["31072008" "7.5000"] ["29082008" "7.5000"] ["30092008" "7.5000"] ["31102008" "7.5000"] ["28112008" "7.5000"] ["30122008" "7.0000"] ["30012009" "6.7500"] ["27022009" "6.7500"] ["31032009" "6.5000"] ["30042009" "6.5000"] ["29052009" "6.2500"] ["30062009" "6.2500"] ["31072009" "6.2500"] ["31082009" "6.2500"] ["30092009" "6.2500"] ["30102009" "6.2500"] ["30112009" "6.2500"] ["30122009" "6.2500"] ["29012010" "6.2500"] ["26022010" "6.2500"] ["31032010" "6.2500"] ["30042010" "6.2500"] ["31052010" "6.2500"] ["30062010" "6.2500"] ["30072010" "6.3750"] ["31082010" "6.3750"] ["30092010" "6.3750"] ["29102010" "6.3750"] ["30112010" "6.3750"] ["30122010" "6.5000"] ["31012011" "6.7500"] ["28022011" "6.7500"] ["31032011" "7.0000"] ["29042011" "7.1250"] ["31052011" "7.1250"] ["30062011" "7.2500"] ["29072011" "7.5000"] ["31082011" "7.5000"] ["30092011" "7.6250"] ["31102011" "7.6250"] ["30112011" "7.6250"] ["30122011" "7.6250"] ["31012012" "7.6250"] ["29022012" "7.5000"] ["30032012" "7.5000"] ["30042012" "7.5000"] ["31052012" "7.5000"] ["29062012" "7.5000"] ["31072012" "7.5000"] ["31082012" "7.5000"] ["28092012" "7.5000"] ["31102012" "7.3750"] ["30112012" "7.3750"] ["28122012" "7.3750"] ["31012013" "7.3750"] ["28022013" "7.3750"] ["29032013" "7.3750"] ["30042013" "7.3750"] ["31052013" "7.3750"] ["28062013" "7.3750"] ["31072013" "7.3750"] ["30082013" "7.3750"] ["30092013" "7.3750"] ["31102013" "7.3750"] ["29112013" "7.3750"] ["27122013" "7.2500"] ["31012014" "7.2500"] ["28022014" "7.2500"]))
(def kb '(["31011996" "13.7500"] ["29021996" "13.7500"] ["31031996" "13.7500"] ["30041996" "13.7500"] ["31051996" "13.7500"] ["30061996" "13.7500"] ["31071996" "13.5000"] ["31081996" "13.5000"] ["30091996" "13.5000"] ["31101996" "13.5000"] ["30111996" "13.5000"] ["31121996" "13.2500"] ["31011997" "13.2500"] ["28021997" "13.2500"] ["31031997" "13.2500"] ["30041997" "13.0000"] ["31051997" "12.7500"] ["30061997" "12.7500"] ["31071997" "13.7500"] ["31081997" "13.7500"] ["30091997" "14.2500"] ["31101997" "14.7500"] ["30111997" "14.7500"] ["31121997" "15.2500"] ["31011998" "15.2500"] ["28021998" "15.2500"] ["31031998" "15.2500"] ["30041998" "15.2500"] ["31051998" "15.2500"] ["30061998" "15.2500"] ["31071998" "15.2500"] ["31081998" "14.7500"] ["30091998" "14.5000"] ["31101998" "13.7500"] ["30111998" "11.7500"] ["31121998" "11.5000"] ["31011999" "11.0000"] ["28021999" "10.0000"] ["31031999" "9.5000"] ["30041999" "9.0000"] ["31051999" "9.0000"] ["30061999" "8.7500"] ["31071999" "8.7500"] ["31081999" "8.7500"] ["30091999" "8.5000"] ["31101999" "8.5000"] ["30111999" "8.2500"] ["31121999" "8.2500"] ["31012000" "8.0000"] ["29022000" "8.0000"] ["31032000" "8.0000"] ["28042000" "8.0000"] ["31052000" "8.0000"] ["30062000" "8.0000"] ["31072000" "8.0000"] ["31082000" "8.0000"] ["29092000" "7.7500"] ["31102000" "7.7500"] ["30112000" "7.7500"] ["29122000" "7.7500"] ["31012001" "7.7500"] ["28022001" "7.2500"] ["30032001" "7.2500"] ["30042001" "7.2500"] ["31052001" "7.2500"] ["29062001" "7.2500"] ["31072001" "7.2500"] ["31082001" "7.2500"] ["28092001" "7.2500"] ["31102001" "7.2500"] ["30112001" "7.2500"] ["28122001" "7.0000"] ["31012002" "7.0000"] ["28022002" "7.0000"] ["29032002" "7.0000"] ["30042002" "7.0000"] ["31052002" "7.0000"] ["28062002" "7.0000"] ["31072002" "7.0000"] ["30082002" "7.0000"] ["30092002" "7.0000"] ["31102002" "6.7500"] ["29112002" "6.7500"] ["27122002" "6.7500"] ["31012003" "6.7500"] ["28022003" "6.7500"] ["31032003" "6.5000"] ["30042003" "6.5000"] ["30052003" "6.5000"] ["30062003" "5.7500"] ["31072003" "5.5000"] ["29082003" "5.5000"] ["30092003" "5.5000"] ["31102003" "5.5000"] ["28112003" "5.5000"] ["31122003" "5.5000"] ["30012004" "5.5000"] ["27022004" "5.5000"] ["31032004" "5.5000"] ["30042004" "5.5000"] ["31052004" "5.5000"] ["30062004" "5.5000"] ["30072004" "5.5000"] ["31082004" "5.5000"] ["30092004" "5.5000"] ["29102004" "5.5000"] ["30112004" "5.5000"] ["30122004" "5.5000"] ["31012005" "5.5000"] ["28022005" "5.5000"] ["31032005" "5.5000"] ["29042005" "5.5000"] ["31052005" "5.5000"] ["30062005" "5.5000"] ["29072005" "5.7500"] ["31082005" "5.7500"] ["30092005" "6.0000"] ["31102005" "6.2500"] ["30112005" "6.2500"] ["30122005" "6.5000"] ["31012006" "6.7500"] ["28022006" "6.7500"] ["31032006" "7.2500"] ["28042006" "7.5000"] ["31052006" "7.5000"] ["30062006" "7.5000"] ["31072006" "7.5000"] ["31082006" "7.7500"] ["29092006" "7.7500"] ["31102006" "7.7500"] ["30112006" "7.7500"] ["29122006" "7.7500"] ["31012007" "7.7500"] ["28022007" "7.7500"] ["30032007" "7.5000"] ["30042007" "7.2500"] ["30052007" "7.0000"] ["29062007" "7.0000"] ["31072007" "6.8500"] ["31082007" "6.8500"] ["28092007" "6.8500"] ["31102007" "6.8500"] ["30112007" "6.8500"] ["31122007" "6.8500"] ["31012008" "6.8500"] ["29022008" "6.8500"] ["31032008" "6.8500"] ["30042008" "6.8500"] ["30052008" "6.8500"] ["30062008" "7.2500"] ["31072008" "7.2500"] ["29082008" "7.2500"] ["30092008" "7.2500"] ["31102008" "7.2500"] ["28112008" "7.2500"] ["30122008" "6.7500"] ["30012009" "6.5000"] ["27022009" "6.2500"] ["31032009" "6.2500"] ["30042009" "6.1000"] ["29052009" "5.8500"] ["30062009" "5.8500"] ["31072009" "5.8500"] ["31082009" "5.8500"] ["30092009" "5.8500"] ["30102009" "5.8500"] ["30112009" "5.8500"] ["30122009" "5.8500"] ["29012010" "5.8500"] ["26022010" "5.8500"] ["31032010" "5.8500"] ["30042010" "5.8500"] ["31052010" "5.8500"] ["30062010" "5.8500"] ["30072010" "6.0000"] ["31082010" "6.0000"] ["30092010" "6.0000"] ["29102010" "6.0000"] ["30112010" "6.0000"] ["30122010" "6.1200"] ["31012011" "6.3700"] ["28022011" "6.3700"] ["31032011" "6.6200"] ["29042011" "6.7500"] ["31052011" "6.7500"] ["30062011" "6.8700"] ["29072011" "7.1200"] ["31082011" "7.1200"] ["30092011" "7.2500"] ["31102011" "7.2500"] ["30112011" "7.2500"] ["30122011" "7.2500"] ["31012012" "7.2500"] ["29022012" "7.1300"] ["30032012" "7.1300"] ["30042012" "7.1300"] ["31052012" "7.1300"] ["29062012" "7.1300"] ["31072012" "7.1300"] ["31082012" "7.1300"] ["28092012" "7.1300"] ["31102012" "7.0000"] ["30112012" "7.0000"] ["28122012" "7.0000"] ["31012013" "7.0000"] ["28022013" "7.0000"] ["29032013" "7.0000"] ["30042013" "7.0000"] ["31052013" "7.0000"] ["28062013" "7.0000"] ["31072013" "7.0000"] ["30082013" "7.0000"] ["30092013" "7.0000"] ["31102013" "7.0000"] ["29112013" "7.0000"] ["27122013" "6.7500"] ["31012014" "6.8800"] ["28022014" "6.8750"]))

(defn diff [one two]
  (partition 2 (interleave (map first one) (map #(format "%.4f" (apply - %))
                                               (partition 2 (interleave (map read-string (map last one))
                                                                        (map read-string (map last two))))))))
