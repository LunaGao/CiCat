from flask import Flask, url_for, redirect, render_template
app = Flask(__name__, template_folder='../templates')


@app.route('/')
def default_route():
    url_login = url_for('login')
    return redirect(url_login)


@app.route('/login')
def login():
    return render_template('login.html')


@app.route('/test/<int:id>')
def test(id):
    return 'get id is %s' % id


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=6950)
