(ns house-loan.core
  (:require [house-loan.date :as d]))

(take 2 (d/range-last-date-of-month-string "31011996"))
