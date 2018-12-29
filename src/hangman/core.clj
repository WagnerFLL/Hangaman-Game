(ns hangman.core
  (:gen-class))

(def total-lives 6)
(def secret-word "ALEMANHA")

(defn lost [] 
  (print "You died!"))

(defn remove-matches [word choices]
  (remove (fn [lett] (contains? choices (str lett) )) word))

(defn hit-whole-word? [word choices]
  (empty? (remove-matches word choices)))

(defn get-let! [] (read-line))

(defn is-contained? [word lett] (.contains word lett))

(defn show-state [lives word choices]
  (println "Lives: " lives)
  (doseq [lett (seq word)]
    (if (contains? choices (str lett))
      (print lett " ")
      (print "? ")))
  (println "")
  (println ""))

(defn play [lives word choices]
  (show-state lives word choices)
  (cond 
    (= lives 0) (lost)
    
    (hit-whole-word? word choices)
      (print "You win!")
    
    :else
    (let [lett (get-let!)]
      (if (is-contained? word lett)
        (do
          (println "Ok!")
          (recur lives word (conj choices lett)))

        (do
          (println "-1 life")
          (recur (dec lives) word choices))))))

(defn fib[x]
    (if (= x 0) 0 
    (if (= x 1) 1 
    (+ (fib (- x 1)) (fib (- x 2))))))

(defn sum [x y]
  (if (= x 1)
    (inc y)
    (recur (dec x) (+ y x))))

(defn -main [& args]
  (play total-lives secret-word #{}))

(defn no-interval [x]
  (filter (fn [e] (or (< e 2) (> e 4))) x))