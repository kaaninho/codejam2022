(ns codejam.dice)

(defn dices->number [dices]
  (reduce (fn [acc die]
            (if (<= (:n acc) die)
              {:nr-of-dices (inc (:nr-of-dices acc))
               :n (inc (:n acc))}
              {:nr-of-dices (:nr-of-dices acc)
               :n (:n acc)}))
          {:nr-of-dices 0 :n 1}
          (sort dices)))

;; Input
(defn digits [n]
  (map read-string (clojure.string/split n #" ")))

(defn -main
  [& args]
  (let [test-cases (read-string (read-line))]
    (dotimes [x test-cases]
      (let [number-of-dice (read-string (read-line))
            dices          (digits (read-line))
            how-many       (:nr-of-dices (dices->number dices))]
        (println (str "Case #" (inc x) ": " how-many))))))

(-main)
