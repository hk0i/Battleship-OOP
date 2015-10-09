$runLine = 'java Battleship'
task :clean do
    puts 'Cleaning Battleship...'
    sh "rm *.class"
end

task :build do
    puts 'Compiling Battleship'
    sh 'javac Battleship.java'
end

task :run do
    sh "#{$runLine}"
end

task :test do
    sh "#{$runLine} --show-computer-ships < test_input"
end

task :buildAndRun => [:build, :run] do
    puts 'Build and run Battleship'
end

task :default => :build