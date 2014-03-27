(ns house-loan.core
  (:require [house-loan.date :as d]
            [house-loan.source :as s]
            [clojure-csv.core :as c]))


(clojure.pprint/pprint (map s/csv (take 3 (d/range-last-date-of-month-string "31011996"))))
