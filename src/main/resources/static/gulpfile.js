'use strict';

const gulp = require('gulp');
const sass = require('gulp-sass');
const autoprefixer = require('gulp-autoprefixer');
const concat = require('gulp-concat');

sass.compiler = require('node-sass');

gulp.task('sass', () => {
    return gulp.src('./scss/**/*.scss')
        .pipe(sass())
        .pipe(autoprefixer({
            cascade: false
        }))
        .pipe(concat('style.css'))
        .pipe(gulp.dest('./css'));
});

gulp.task('watch', () => {
    gulp.watch('./scss/**/**/*.scss', gulp.series('sass'));
});

gulp.task('default', gulp.parallel('sass', 'watch'));