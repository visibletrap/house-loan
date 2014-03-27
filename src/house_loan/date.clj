(ns house-loan.date
  (:require [simple-time.core :as t]))

(defn- string-to-datetime [s] (t/parse s "ddMMYYYY"))
(defn- next-month [dt]
  (let [next (t/add-months dt 1)]
    (t/datetime
     (t/datetime->year next)
     (t/datetime->month next)
     (t/days-in-month next))))

(defn- range-date [start]
  (let [next-month (next-month start)]
    (cons next-month (lazy-seq (range-date next-month)))))

(defn range-last-date-of-month-string [start]
  (let [inter-date-time (string-to-datetime start)]
    (map #(t/format % "ddMMYYYY") (range-date inter-date-time))))
