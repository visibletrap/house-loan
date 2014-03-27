(ns house-loan.date
  (:require [simple-time.core :as t]))

(defn- string-to-datetime [s] (t/parse s "ddMMYYYY"))
(defn- datetime-to-string [dt] (t/format dt "ddMMYYYY"))
(defn- next-month [dt]
  (let [next (t/add-months dt 1)]
    (t/datetime
     (t/datetime->year next)
     (t/datetime->month next)
     (t/days-in-month next))))

(defn- range-date [start]
  (let [next-month (next-month start)]
    (cons start (lazy-seq (range-date next-month)))))

(defn range-last-date-of-month-string [start]
  (let [inter-date-time (string-to-datetime start)]
    (map datetime-to-string (range-date inter-date-time))))

(defn- yesterday [dt]
  (t/- dt (t/days->timespan 1)))

(defn yesterday-string [date-string]
  (-> date-string
      string-to-datetime
      yesterday
      datetime-to-string))
