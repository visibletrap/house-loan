(ns house-loan.source
  (:require [org.httpkit.client :as http]
            [house-loan.date :as d]))

(defn- get-csv [url]
  (let [{ :keys [status body] } @(http/get url)]
    (if (= status 200)
      (slurp (:body @(http/get url)) :encoding "tis-620")
      nil)))

(defn- url [date-string]
  (str "http://www.bot.or.th/Thai/Statistics/FinancialMarkets/InterestRate/InterestRate_EN_CSV/IN_CSV_LNE_" date-string ".CSV"))

(defn csv [date-string]
  (if-let [out (get-csv (url date-string))]
    [date-string out]
    (csv (d/yesterday-string date-string))))
