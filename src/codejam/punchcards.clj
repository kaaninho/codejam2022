(ns codejam.punchcards
  (:require [clojure.string :as string]))

(defn first-row [cols]
  (str
   (string/join
    (cons "..+"
          (map (fn [_] "-+")
               (range (dec cols)))))
   "\n"
   (string/join
    (cons "..|"
          (map (fn [_] ".|")
               (range (dec cols)))))
   "\n"
   (string/join
    (cons "+"
          (map (fn [_] "-+")
               (range cols))))))

(defn normal-row [cols]
  (str
   (string/join
    (cons "|"
          (map (fn [_] ".|")
               (range cols))))
   "\n"
   (string/join
    (cons "+"
          (map (fn [_] "-+")
               (range cols))))))

(defn board [rows cols]
  (str (first-row cols)
       "\n"
       (string/join
        "\n"
        (map (fn [_] (normal-row cols))
             (range (dec rows))))))

;; Input
(defn digits [n]
  (map read-string (clojure.string/split n #" ")))

(defn -main
  [& args]
  (let [test-cases (read-string (read-line))]
    (dotimes [x test-cases]
      (let [[rows cols] (digits (read-line))
            the-board (board rows cols)]
        (println (str "Case #" (inc x) ":\n"
                      the-board))))))
(-main)
