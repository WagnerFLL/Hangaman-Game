(ns hangman.core
  (:gen-class))

(def total-lives 6)

(defn lost [] 
  (print "You died!"))

(defn remove-matches [word choices]
  (remove (fn [lett] (contains? choices (str lett) )) word))

(defn hit-whole-word? [word choices]
  (empty? (remove-matches word choices)))

(defn play [lives word choices]
  (if (= lives 0)
    (lost)
    (if (hit-whole-word? word choices)
      (print "You win!")
      (print "Choose a let: "))))

(defn fib[x]
    (if (= x 0) 0 
    (if (= x 1) 1 
    (+ (fib (- x 1)) (fib (- x 2))))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
