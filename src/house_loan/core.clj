(ns house-loan.core
  (:require [house-loan.date :as d]
            [house-loan.source :as s]
            [clojure-csv.core :as c]))

(defn- mlr [name csv]
  (let [data-in-list (c/parse-csv csv :delimiter \|)]
    (last (take 3 (first (filter #(= name (first %)) data-in-list))))))

(defn- date-mlr [name [date csv]]
    [date (mlr name csv)])

;; (date-mlr ["x" "Loan Rates Commercial Banks as of 31 January 1996\nBank|MOR|MLR|MRR|Ceiling|Default|Credit Card\r\nCommercial Banks registered in Thailand||||||\r\nBangkok Bank|14.0000|13.7500|14.0000|16.0000|18.0000|-\r\nKrung Thai Bank|14.0000|13.7500|14.2500|16.2500|18.0000|-\r\nThai Farmers Bank|14.0000|13.7500|14.0000|16.0000|18.0000|-\r\nThe Siam Commercial Bank|14.0000|13.7500|14.2500|16.2500|18.5000|-\r\nBank of Ayudhya|14.2500|13.7500|14.5000|16.5000|18.5000|-\r\nThe Thai Military Bank|14.0000|13.7500|14.2500|16.2500|18.5000|-\r\nThe Siam City Bank|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nBangkok Metropolitan Bank|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nBank of Asia|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nBank Thai|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nDBS Thai Danu Bank|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nStandard Chartered Nakornthon Bank|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nUOB Radanasin Bank|14.7500|14.5000|14.7500|16.7500|19.0000|-\r\nThe Bangkok Bank of Commerce|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nFirst Bangkok City Bank|14.5000|14.5000|14.7500|16.7500|19.0000|-\r\nAverage of Commercial Banks registered in Thailand|14.3333|14.2000|14.5333|16.5333|18.7000|-\r\nForeign Bank Branches||||||\r\nThe Bank of Tokyo-Mitsubishi|-|14.0000|15.7500|17.7500|19.7500|-\r\nCitibank|-|14.0000|14.7600|17.2600|19.5000|-\r\nThe Sakura Bank|-|14.0000|15.7500|17.7500|19.7500|-\r\nHSBC|-|14.2500|14.2500|18.2500|20.2500|-\r\nDeutsche Bank AG.|-|14.5000|14.5000|17.0000|19.0000|-\r\nStandard Chartered Bank|-|14.2500|14.2500|18.2500|19.0000|-\r\nThe Chase Manhattan Bank|-|16.0000|-|-|19.0000|-\r\nCredit Agricole Indosuez|-|14.0000|14.0000|17.0000|19.0000|-\r\nBank of America, National Association|-|14.0000|15.2500|17.2500|19.0000|-\r\nBharat Overseas Bank|-|14.0000|14.5000|16.5000|15.0000|-\r\nABN-AMRO N.V.|-|11.5000|13.5000|15.5000|19.0000|-\r\nThe International Commercial Bank of China|-|13.7500|14.7500|15.7500|19.0000|-\r\nRHB Bank Berhad|-|14.0000|14.7500|16.7500|18.0000|-\r\nOversea Chinese Banking Corporation|-|14.0000|15.5000|18.0000|19.0000|-\r\nAverage of Foreign Bank Branches|-|14.0179|14.7315|17.1546|18.8750|-\r\n"])

(defn get-data [name from nmonth]
  (map #(date-mlr name %) (map s/csv (take nmonth (d/range-last-date-of-month-string from)))))

(get-data "Bangkok Bank" "31012012" 12)
(get-data "Bank of Ayudhya" "31012012" 12)
(get-data "Kasikornbank" "31012012" 12)
