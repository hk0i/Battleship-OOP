$runLine = 'java com.code2coda.battleship.Battleship'
task :clean do
    puts 'Cleaning Battleship...'
    sh "find . -iname \"*.class\" -exec rm {} +"
end

task :build do
    puts 'Compiling Battleship'
    sh 'javac com/code2coda/battleship/Battleship.java'
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