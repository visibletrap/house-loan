(ns house-loan.source
  (:require [org.httpkit.client :as http]
            [clojure.string :as s]
            [clojure-csv.core :as csv]
            [simple-time.core :as t]))

(defn get-csv [url]
  (let [{ :keys [status body] } @(http/get url)]
    (if (= status 200)
      (slurp (:body @(http/get url)) :encoding "tis-620")
      "")))

(def url "http://www.bot.or.th/Thai/Statistics/FinancialMarkets/InterestRate/InterestRate_EN_CSV/IN_CSV_LNE_27032014.CSV")

;; (csv/parse-csv (get-csv url) :delimiter \|)


