(ns house-loan.extract
  (require [clojure-csv.core :as c]))

(defn- match-name? [name row]
  (= name (first row)))

(defn- match-row [name rows]
  (first (filter #(match-name? name %) rows)))

(defn mlr [name csv]
  (let [rows (c/parse-csv csv :delimiter \|)
        match-record (match-row name rows)]
    (read-string (last (take 3 match-record)))))

