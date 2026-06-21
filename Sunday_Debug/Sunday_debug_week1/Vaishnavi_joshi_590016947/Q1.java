#include <stdio.h>

#define STADIUMS 3
#define MAX_GOALS 100
#define PLAYERS 5

int goals[STADIUMS][MAX_GOALS];
int goalCount[STADIUMS] = {0};
int playerGoals[PLAYERS] = {0};

void addGoal(int stadium, int minute, int playerID)
{
    if (goalCount[stadium] >= MAX_GOALS)
    {
        printf("Stadium is full\n");
        return;
    }

    goals[stadium][goalCount[stadium]] = minute;
    playerGoals[playerID]++;
    goalCount[stadium]++;
}

int totalGoals()
{
    int total = 0;

    for (int s = 0; s < STADIUMS; s++)
    {
        total += goalCount[s];
    }

    return total;
}

int topScorer()
{
    int maxG = playerGoals[0];
    int winner = 0;

    for (int p = 1; p < PLAYERS; p++)
    {
        if (playerGoals[p] > maxG)
        {
            maxG = playerGoals[p];
            winner = p;
        }
    }

    return winner;
}

void displayStadium(int stadium)
{
    for (int i = 0; i < goalCount[stadium]; i++)
    {
        printf("%d ", goals[stadium][i]);
    }
    printf("\n");
}

int main()
{
    addGoal(0, 15, 0);
    addGoal(0, 42, 1);

    addGoal(1, 8, 2);
    addGoal(1, 67, 2);

    addGoal(2, 23, 2);
    addGoal(2, 55, 3);
    addGoal(2, 80, 4);

    printf("Total Goals: %d\n", totalGoals());

    printf("Top Scorer: Player %d\n", topScorer());

    printf("Stadium 0 goals: ");
    displayStadium(0);

    printf("Stadium 1 goals: ");
    displayStadium(1);

    printf("Stadium 2 goals: ");
    displayStadium(2);

    return 0;
}