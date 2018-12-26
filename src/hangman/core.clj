(ns hangman.core
  (:gen-class))

(def total-lives 6)

(defn lost [] 
	(print "You died!"))

(defn play [lives]
	(if (= lives 0)
		(lost)
		(do
			(print lives " ")
			(play (dec lives)))))

(defn fib[x]
    (if (= x 0) 0 
    (if (= x 1) 1 
    (+ (fib (- x 1)) (fib (- x 2))))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
