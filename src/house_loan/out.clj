(ns house-loan.out
  (require [clojure-csv.core :as c]))

(defn to-csv [date & mlrs]
  (let [values (map #(map :value %) mlrs)
        values-string (map #(map str %) values)]
    (c/write-csv (apply map vector date values-string))))
