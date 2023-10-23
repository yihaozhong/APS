// the printing job is assigned with prioirty from 1 (lowese) to 9 (highest)
// the printer manage job as follow:
// select the first job from queue
// if there is some job with higher priority then the selected job, put the
// selected job at the end of the queue without print it
// otherwise, print the selected job

// the first line of input has two integer n and m, where n is the number of job
// in the queue and m is the position of the job, 0 being the first position
// the second line has n integer, giving the priority of jobs in the queue, from
// the first to the last position

// output one line with a single number the number of minutes until job is
// printed. (how ling it will takesbefore that job is printed.). Printing a
// single job takes 1 minutes