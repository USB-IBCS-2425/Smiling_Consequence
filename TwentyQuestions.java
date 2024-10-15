import java.util.*;

class TwentyQuestions {
   
    String q1 = "";
    String q2 = "";
    String q3 = "";
    String q4 = "";
    String q5 = "";
    int q = 0;
    ArrayList<String> currentAnswers = new ArrayList<String>();
    String[] answers = new String[10];

    public TwentyQuestions(String[] answers) {
        this.answers = answers;
        for (int i = 0; i < answers.length; i++) {
            currentAnswers.add(answers[i]);
        }
    }

    public String askQuestion(Scanner s) {
        
        String question = "";

        if (q == 0) {
            question = "Is this F1 Team Located in the UK? (Yes/No *Must Be Capital)";
        } 
        else if (q == 1) {
            question = "Has this F1 Team Won a WCC in the 21st Century? (Yes/No)";
        } 
        else if (q == 2) {
            question = "Does This Team Currently Have a Championship Driver? (Yes/No)";
        } 
        else if (q == 3) {
            question = "Does This Team Have a Blue or Green Livery/Primay Color? (Yes/No)";
        } 
        else if (q == 4) {
            question = "Is This Team Part of the Red Bull Family? (Yes/No)";
        }

        System.out.println(question);
        String answer = s.nextLine(); 

        
        if (q == 0) {
            q1 = answer;
        } 
        else if (q == 1) {
            q2 = answer;
        } 
        else if (q == 2) {
            q3 = answer;
        } 
        else if (q == 3) {
            q4 = answer;
        } 
        else if (q == 4) {
            q5 = answer;
        }

        q++;

        return question;
    }

    public void updateAnswers() {
        
        if (q1.contains("Yes")) {
            currentAnswers.remove("Ferrari");
            currentAnswers.remove("Sauber");
            currentAnswers.remove("Haas");
            currentAnswers.remove("RB"); // Red Bull, Mercedes, McLaren, Aston, Williams, Alpine
            if (q2.contains("Yes")) {
                currentAnswers.remove("McLaren");
                currentAnswers.remove("Aston Martin");
                currentAnswers.remove("Williams"); // Red Bull, Mercedes, Alpine
                if (q3.contains("Yes")) {
                    currentAnswers.remove("Alpine"); // Red Bull, Mercedes
                    if (q5.contains("Yes")) {
                        currentAnswers.remove("Mercedes"); // Red Bull *should guess
                    }
                    else if (q5.contains("No")) {
                        currentAnswers.remove("Red Bull"); // Mercedes *should guess
                    }
                }
                else if (q3.contains("No")) {
                    currentAnswers.remove("Red Bull");
                    currentAnswers.remove("Mercedes"); // Alpine *should guees
                }
            }
            else if (q2.contains("No")) {
                currentAnswers.remove("Red Bull");
                currentAnswers.remove("Mercedes");
                currentAnswers.remove("Alpine"); // McLaren, Aston, Williams
                if (q3.contains("Yes")) {
                    currentAnswers.remove("McLaren");
                    currentAnswers.remove("Williams"); // Aston *should guess
                }
                else if (q3.contains("No")) {
                    currentAnswers.remove("Aston Martin"); // McLaren, Williams
                    if (q4.contains("Yes")) {
                        currentAnswers.remove("McLaren"); // Williams *should guess
                    }
                    else if (q4.contains("No")) {
                        currentAnswers.remove("Williams"); // McLaren *should guess
                    }
                }
            }
        }
        else if (q1.contains("No")) { 
            currentAnswers.remove("Mercedes");
            currentAnswers.remove("Red Bull");
            currentAnswers.remove("McLaren");
            currentAnswers.remove("Aston Martin");
            currentAnswers.remove("Williams");
            currentAnswers.remove("Alpine"); // Ferrari, RB, Sauber, Haas
            if (q2.contains("Yes")) {
                currentAnswers.remove("RB");
                currentAnswers.remove("Sauber");
                currentAnswers.remove("Haas"); // Ferrari *should guess
            }
            else if (q2.contains("No")) {
                currentAnswers.remove("Ferrari"); // RB, Sauber, Haas
                if (q4.contains("Yes")) {
                    currentAnswers.remove("Haas"); // RB, Sauber
                    if (q5.contains("Yes")) {
                        currentAnswers.remove("Sauber"); // RB *should guess
                    }
                    else if (q5.contains("No")) {
                        currentAnswers.remove("RB"); // Sauber *should guess
                    }
                }
                else if (q4.contains("No")) {
                    currentAnswers.remove("RB");
                    currentAnswers.remove("Sauber"); // Haas *should guess
                }
            }       
        }
    }

    public String guess() {
        if (currentAnswers.size() == 1) {
            return currentAnswers.get(0);
        }     
        else {
            return "No guess";
        }
    }

    public void reset() {
        q = 0;
        currentAnswers.clear();
        currentAnswers.addAll(Arrays.asList(answers));
        q1 = "";
        q2 = "";
        q3 = "";
        q4 = "";
        q5 = "";

    }

    public static void main(String[] args) {
        String[] answers = {"Red Bull", "Ferrari", "Mercedes", "McLaren", "Aston Martin", "RB", "Sauber", "Williams", "Haas", "Alpine"};
        boolean again = true;
        int dumb = 1;

        Scanner s = new Scanner(System.in);
        TwentyQuestions game = new TwentyQuestions(answers);


        System.out.println("Welcome to Twenty Questions F1 Edition: Choose ANY Team and Enter 'Start' To Begin.");
        String inp = s.nextLine();

        while (!inp.contains("Start")) {
            System.out.println("Try Again! Enter 'Start' To Begin");
            inp = s.nextLine();
            dumb++;
            if (inp.contains("Start")) {
                break;
            }

            if (dumb == 10) {
                System.out.println("Whatever! Here's the First Question and the List of Teams: ");
                inp = "Start";
            }
        }
        
        System.out.println("Here is the List of Teams:");
        for (int i = 0; i < answers.length; i++) {
            System.out.println("- " + answers[i]);
        }

        while (inp.contains("Start")) {
            
            while (again) {
            
            game.reset();

            while (game.q < 5) {
                
                game.askQuestion(s);
                game.updateAnswers();

                if (game.currentAnswers.size() == 1) {
                    System.out.println("The Team Is: " + game.guess());
                    break;
                }
            }

            System.out.println("Do You Want To Play Again? (Yes/No)");
            String response = s.nextLine();
            again = response.contains("Yes");
    
        }
            String[] funFact = new String[4];
            funFact[0] = "The fastest F1 lap ever recorded was by Lewis Hamilton at the 2020 Italian Grand Prix, clocking in at an astonishing 263.587 km/h (163.0 mph) during a qualifying session.";
            funFact[1] = "The quickest pit stop in F1 history was performed by the Red Bull Racing team in 2019, taking just 1.82 seconds to change all four tires!";
            funFact[2] = "Max Verstappen became the youngest driver to compete in an F1 race at just 17 years and 166 days old in 2015. He also holds the record for the youngest winner of a race at 18 years and 227 days.";
            funFact[3] = "Michael Schumacher and Lewis Hamilton share the record for the most World Championships, each having won the title seven times, showcasing their dominance in the sport.";
            System.out.println("Thanks for Playing! Here's a Fun Fact: " + funFact[(int)(Math.random() * 4)]);
            s.close();
            break;
        }
    }


}